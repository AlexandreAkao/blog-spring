package br.com.comments.config;

import br.com.comments.model.Comment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.Duration;

//@Configurable
public class RedisConfig {
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
}
