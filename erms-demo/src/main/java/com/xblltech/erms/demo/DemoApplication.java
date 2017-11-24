package com.xblltech.erms.demo;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashMap;
import java.util.Map;

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

    @RequestMapping(value = "/demo2" ,method = RequestMethod.GET)
    @ApiOperation("Demo测试")
    public Result demo2(@RequestParam int i, @RequestParam String s){
        Map<String, Object> result = new HashMap<>();
        result.put("Integer", i);
        result.put("String", s);
        Result r = new Result();
        r.setData(result);
        r.setCode(200);
        return r;
    }

    @RequestMapping(value = "/demo3/{s}" ,method = RequestMethod.GET)
    @ApiOperation("Demo测试")
    public Result demo3(@PathVariable String s){
        Map<String, Object> result = new HashMap<>();
        result.put("PathString", s);
        Result r = new Result();
        r.setData(result);
        r.setCode(200);
        return r;
    }


}
