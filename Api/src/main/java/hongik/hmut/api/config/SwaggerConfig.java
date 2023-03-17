package hongik.hmut.api.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
// import springfox.documentation.builders.ApiInfoBuilder;
// import springfox.documentation.builders.PathSelectors;
// import springfox.documentation.builders.RequestHandlerSelectors;
// import springfox.documentation.service.ApiInfo;
// import springfox.documentation.spi.DocumentationType;
// import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@RequiredArgsConstructor
public class SwaggerConfig {

    private final ApplicationContext applicationContext;
    //
    //    @Bean
    //    public OpenAPI openAPI(ServletContext servletContext) {
    //        String contextPath = servletContext.getContextPath();
    //        Server url = new Server().url(contextPath);
    //        return new OpenAPI().servers(List.of(url)).components(authSetting)
    //    }

    //    @Bean
    //    public Docket api() {
    //        return new Docket(DocumentationType.OAS_30)
    //                .useDefaultResponseMessages(false)
    //                .select()
    //                .apis(RequestHandlerSelectors.basePackage("hongik.hmut.api.controller"))
    //                .paths(PathSelectors.any())
    //                .build()
    //                .apiInfo(apiInfo());
    //    }
    //
    //    private ApiInfo apiInfo() {
    //        return new ApiInfoBuilder()
    //                .title("H-Mut Swagger Document.")
    //                .description("H-Mut 팀 API 문서입니다.")
    //                .version("0.1")
    //                .build();
    //    }
}
