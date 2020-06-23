package br.unifor.app.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // https://mkyong.com/spring-boot/spring-rest-spring-security-example/
    // https://dzone.com/articles/securing-urls-using-springnbspsecurity
    // https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/config/annotation/web/builders/HttpSecurity.html
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement() // desabilitar sessao
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.csrf().disable().authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }

    @Autowired
    public void configureGlobal (AuthenticationManagerBuilder authManagerBuilder) throws Exception {
        authManagerBuilder.inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}admin").roles("ADMIN");
    }
}
