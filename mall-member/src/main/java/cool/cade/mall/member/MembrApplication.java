package cool.cade.mall.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MembrApplication {

    public static void main(String[] args) {
        SpringApplication.run(MembrApplication.class, args);
    }

}
