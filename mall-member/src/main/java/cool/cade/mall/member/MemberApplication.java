package cool.cade.mall.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableFeignClients(basePackages = "cool.cade.mall.member.feign")
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = {"cool.cade.mall.member","cool.cade.mall.common.config.springdoc"})
public class MemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemberApplication.class, args);
    }

}
