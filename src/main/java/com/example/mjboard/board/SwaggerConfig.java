package com.example.mjboard.board;

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
    public Docket SwaggerConfigAPI(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(swaggerInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.mjboard.board")) // 해당 패키지 하단에 있는 Controller 아래의 내용을 읽어
                .paths(PathSelectors.any()) // mapping된 resource들을 문서화 시켜주는 코드.
                .build() // swaggerInfo를 설정해주는 것으로 문서에 대한 설명과 작성자 정보를 입력할수 있다.
                .useDefaultResponseMessages(false);
    }

    private ApiInfo swaggerInfo(){
        return new ApiInfoBuilder()
                .title("Spring API")
                .description("API")
                .license("WalkerLab")
                .version("1")
                .build();
    }
}
