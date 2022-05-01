package cool.cade.mall.thirdparty.config;

import cool.cade.mall.common.config.springdoc.SwaggerProperties;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.boot.SpringBootVersion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class SpringdocConfig {
    private final SwaggerProperties swaggerProperties;
    private final Server tryItServer;

//    private final OpenApiCustomiser openApiCustomiser;

    public SpringdocConfig(SwaggerProperties swaggerProperties) {
        this.swaggerProperties = swaggerProperties;
        this.tryItServer = new Server();
        this.tryItServer.setUrl(this.swaggerProperties.getTryHost());
//        this.openApiCustomiser = openApi -> openApi.servers(Collections.singletonList(this.tryItServer));
    }


    @Bean
    public OpenAPI mallOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("第三方服务模块API文档")
                        .description("A-LITTLE-MALL的微服务Mall-ThirdParty")
                        .contact(new Contact()
                                .name("Ander")
                                .email("cade@cade.cool"))
                        .version("Application Version: " + swaggerProperties.getApplicationVersion() + "\n"
                                +"Spring Boot Version: " + SpringBootVersion.getVersion())
                        .license(new License().name("Apache 2.0").url("https://www.apache.org/licenses/LICENSE-2.0.html")))
                .externalDocs(new ExternalDocumentation()
                        .description("springdoc 文档")
                        .url("https://springdoc.org/"))
                .servers(Collections.singletonList(this.tryItServer));
    }

}
