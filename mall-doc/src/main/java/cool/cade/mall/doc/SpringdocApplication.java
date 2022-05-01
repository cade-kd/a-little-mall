package cool.cade.mall.doc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = {"cool.cade.mall.doc",
        "cool.cade.mall.common.config.springdoc"})
public class SpringdocApplication
{
    public static void main( String[] args ) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringdocApplication.class, args);
        String[] allBeanNames = context.getBeanDefinitionNames();
        for(String beanName : allBeanNames) {
            System.out.println(beanName);
        }
    }
}
