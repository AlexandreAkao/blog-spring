package br.com.comments;

import br.com.comments.model.Comment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class CommentsApplication {
	@Value("${spring.redis.host}")
	String host;

	@Value("${spring.redis.port}")
	Integer port;

	@Bean
	public LettuceConnectionFactory redisConnectionFactory() {
		return new LettuceConnectionFactory(new RedisStandaloneConfiguration(this.host, this.port));
	}

	@Bean
	public RedisTemplate<String, Comment> redisTemplate() {
		final RedisTemplate<String, Comment> template = new RedisTemplate<String, Comment>();
		template.setConnectionFactory(redisConnectionFactory());
		return template;
	}

	public static void main(String[] args) {
		SpringApplication.run(CommentsApplication.class, args);
	}
}
