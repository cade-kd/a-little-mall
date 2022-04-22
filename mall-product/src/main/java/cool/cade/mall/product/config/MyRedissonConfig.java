package cool.cade.mall.product.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @author: cade
 * @create: 2020-06-11 09:39
 **/

@Configuration
@RefreshScope
public class MyRedissonConfig {

    @Value("${spring.redis.host}")
    String redisHost;

    @Value("${spring.redis.port}")
    String redisPort;

    @Value("${spring.redis.password}")
    String redisPassword;
    /**
     * 所有对 Redisson 的使用都是通过 RedissonClient
     *
     * @return
     * @throws IOException
     */
    @Bean(destroyMethod = "shutdown")
    public RedissonClient redisson() throws IOException {
        // 1、创建配置
        Config config = new Config();
        // Redis url should start with redis:// or rediss://
        config.useSingleServer().setAddress("redis://"+redisHost+":"+redisPort).setPassword(redisPassword);

        // 2、根据 Config 创建出 RedissonClient 实例
        return Redisson.create(config);
    }
}
