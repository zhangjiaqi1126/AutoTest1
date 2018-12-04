package com.course.model.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket Api() {
        return new Docket(DocumentationType.SWAGGER_2)
                //传入下边定义的方法
                .apiInfo(apiInfo())
                //配置访问的路径
                .pathMapping("/")
                .select()
                .paths(PathSelectors.regex("/.*")
                ).build();

}

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("我的接口文档")//文档的名字
        .contact(new Contact("zhangjiaqi","",""))
        .description("这是我的swaggerui生成的接口文档")
        .version("1.0.0.0")
        .build();
    }
    }
