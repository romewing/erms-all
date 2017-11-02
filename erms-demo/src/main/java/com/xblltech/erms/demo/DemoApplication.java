package com.xblltech.erms.demo;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author ZHANG Yi
 */
@SpringBootApplication
@RestController
@EnableSwagger2

@Api
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class);
    }

    @RequestMapping(value = "/demo" ,method = RequestMethod.GET)
    @ApiOperation(value = "这是Value值")
    public String demo() {
        return "hello demo";
    }

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xblltech"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("更多Spring Boot相关文章请关注：http://blog.didispace.com/")
                .termsOfServiceUrl("http://blog.didispace.com/")
                .contact(new Contact("name-zhangyi", "www.url.com.cn", "email@qq.com"))
                .version("1.0")
                .build();
    }
}
