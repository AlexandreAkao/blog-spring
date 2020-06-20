package br.com.comments;

import br.com.comments.model.Comment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

@SpringBootApplication
public class CommentsApplication {

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory();
	}

	@Bean
	public RedisTemplate<String, Comment> redisTemplate() {
		final RedisTemplate<String, Comment> template = new RedisTemplate<String, Comment>();
		template.setConnectionFactory(jedisConnectionFactory());
		return template;
	}

	public static void main(String[] args) {
		SpringApplication.run(CommentsApplication.class, args);
	}
}
