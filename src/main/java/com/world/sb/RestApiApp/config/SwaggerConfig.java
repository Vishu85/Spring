package com.world.sb.RestApiApp.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by Vishu on 6/23/2017.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public Docket TopicApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("com.world.sb.RestApiApp.controller"))
                .paths(regex("/topics.*"))
                .build()
                .apiInfo(metaData());
    }

    public ApiInfo metaData(){
        ApiInfo apiInfo = new ApiInfo(
                "Spring Boot Rest Api",
                "Spring Boot Rest Api for Topics",
                "1.0",
                "Terms of Service",
                 new Contact("Vishu Rastogi", "google.com","Abc@gmail.com" ),
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0");
        return apiInfo;
    }
}
