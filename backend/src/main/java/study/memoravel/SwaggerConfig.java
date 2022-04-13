package study.memoravel;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket restAPI(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("study.memoravel.api"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo buildApiInfo(){
        return new ApiInfoBuilder()
                .title("Memoravel REST API")
                .description("1인 여행 가이드 서비스 Memoravel 의 API 명세 입니다.")
                .build();
    }
}
