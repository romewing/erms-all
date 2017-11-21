package com.xblltech.erms.demo;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
    @ApiOperation("Demo测试")
    public String demo() {
        return "hello demo";
    }


}
