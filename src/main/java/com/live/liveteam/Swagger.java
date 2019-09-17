package com.live.liveteam;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * SWAGGER_2 API接口文档配置文件 访问地址：http://localhost:8080/swagger-ui.html#!
 */
@Configuration
public class Swagger {

    @Bean
    public Docket createRestApi() {
        ParameterBuilder tokenPar1 = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        tokenPar1.name("token").description("令牌：用户登陆成功后需传").modelRef(new ModelRef("string")).parameterType("header")
            .required(false).build();
        pars.add(tokenPar1.build());
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
            .apis(RequestHandlerSelectors.basePackage("com.live.liveteam.controller")).paths(PathSelectors.any()).build()
            .globalOperationParameters(pars).apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("生活社-商城接口文档 API-文档").description("").termsOfServiceUrl("").version("1.0")
            .build();
    }
}
