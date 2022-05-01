package cool.cade.mall.doc.config;

import cool.cade.mall.common.config.springdoc.SwaggerProperties;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.GroupedOpenApi;
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

        this.tryItServer.setUrl(swaggerProperties.getTryHost());
//        this.openApiCustomiser = openApi -> openApi.servers(Collections.singletonList(this.tryItServer));
    }

//    public class GlobalHeaderAdder implements OperationCustomizer {
//        @Override
//        public Operation customize(Operation operation, HandlerMethod handlerMethod) {
//            operation.addParametersItem(new Parameter().$ref("#/components/parameters/ClientID"));
//            operation.addSecurityItem(new SecurityRequirement().addList("Authorization"));
//            List<Parameter> parameterList = operation.getParameters();
//            if (parameterList!=null && !parameterList.isEmpty()) {
//                Collections.rotate(parameterList, 1);
//            }
//            return operation;
//        }
//    }

    @Bean
    public OpenAPI mallOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("A-LITTLE-MALL")
                                .title(swaggerProperties.getApplicationName() + " Api Doc")
                                .description(swaggerProperties.getApplicationDescription())
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

//    @Bean
//    @Lazy(false)
//    public List<GroupedOpenApi> apis(SwaggerUiConfigParameters swaggerUiConfigParameters, RouteDefinitionLocator locator) {
//        List<GroupedOpenApi> groups = new ArrayList<>();
//        List<RouteDefinition> definitions = locator.getRouteDefinitions().collectList().block();
//        System.out.println("=-=-=-=-=-=-=");
//        System.out.println(definitions);
//        definitions.stream().filter(routeDefinition -> routeDefinition.getId().matches("mall-*"))
//                .forEach(routeDefinition -> {
//                    System.out.println("=====================");
//                    System.out.println(routeDefinition);
//                    String name = routeDefinition.getId().replaceAll("mall-", "");
//                    swaggerUiConfigParameters.addGroup(name);
//                    GroupedOpenApi.builder().pathsToMatch("/" + name + "/**").group(name).build();
//                });
//        return groups;
//    }

    @Bean
    public GroupedOpenApi productApi() {
        return GroupedOpenApi.builder()
                .group("product")
                .packagesToScan("cool.cade.mall.product")
//                .pathsToMatch("/product/**")
                .build();

    }

    @Bean
    public GroupedOpenApi memberApi() {
        return GroupedOpenApi.builder()
                .group("member")
                .packagesToScan("cool.cade.mall.member")
//                .pathsToMatch("/member/**")
//                .addOpenApiCustomiser(openApiCustomiser)
                .build();
    }

    @Bean
    public GroupedOpenApi couponApi() {
        return GroupedOpenApi.builder()
                .group("coupon")
                .packagesToScan("cool.cade.mall.coupon")
                .build();
    }

    @Bean
    public GroupedOpenApi orderApi() {
        return GroupedOpenApi.builder()
                .group("order")
                .packagesToScan("cool.cade.mall.order")
                .build();
    }

    @Bean
    public GroupedOpenApi wareApi() {
        return GroupedOpenApi.builder()
                .group("ware")
                .packagesToScan("cool.cade.mall.ware")
                .build();
    }

    @Bean
    public GroupedOpenApi thirdpartyApi() {
        return GroupedOpenApi.builder()
                .group("thirdparty")
                .packagesToScan("cool.cade.mall.thirdparty")
                .build();
    }


    @Bean
    public GroupedOpenApi springdocApi() {

        return GroupedOpenApi.builder()
                .group("docs")
                .packagesToScan("cool.cade.mall.doc")
//                .addOpenApiCustomiser(openApiCustomiser)
                .build();
    }


}