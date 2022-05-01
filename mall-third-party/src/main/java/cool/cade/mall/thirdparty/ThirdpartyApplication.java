package cool.cade.mall.thirdparty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = {"cool.cade.mall.thirdparty","cool.cade.mall.common.config.springdoc"})
public class ThirdpartyApplication {
    public static void main( String[] args ){
        SpringApplication.run(ThirdpartyApplication.class, args);
    }
}
