package com.example.airly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.Locale;

@SpringBootApplication
@EnableSwagger2
public class AirlyApplication {

    public static void main(String[] args) {
        SpringApplication.run(AirlyApplication.class, args);
    }

    @Bean
    public Docket swaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/airly/*"))
                .apis(RequestHandlerSelectors.basePackage("com.example"))
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails() {
        return new ApiInfo(
                "Airly sensors API",
                "API created to manage sensors",
                "1.0",
                "Free to use",
                new Contact("Wojciech Ankus", "https://github.com/vojteq", ""),
                null,
                null,
                Collections.emptyList()
        );
    }
}
