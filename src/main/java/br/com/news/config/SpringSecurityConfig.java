package br.com.news.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
            .withUser("admin").password("{noop}admin").roles("ADMIN");
    }

    // Secure the endpoins with HTTP Basic authentication
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.httpBasic()
            .and()
            .authorizeRequests()
            .antMatchers(HttpMethod.POST,"/admin/category").hasRole("ADMIN")
            .antMatchers(HttpMethod.DELETE, "/admin/category/**").hasRole("ADMIN")
            .antMatchers(HttpMethod.PUT, "/admin/category/**").hasRole("ADMIN")
            .antMatchers(HttpMethod.POST,"/admin/news").hasRole("ADMIN")
            .antMatchers(HttpMethod.DELETE, "/admin/news/**").hasRole("ADMIN")
            .antMatchers(HttpMethod.PUT, "/admin/news/**").hasRole("ADMIN")
            .antMatchers(HttpMethod.POST, "/admin/image").hasRole("ADMIN")
            .and()
            .csrf().disable()
            .formLogin().disable();

    }

}