package com.xblltech.erms.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZHANG Yi
 */
@SpringBootApplication
@RestController
@EnableResourceServer
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class);
    }

    @RequestMapping(value = "/demo" ,method = RequestMethod.GET)
    public String demo() {
        return "hello demo";
    }


}
