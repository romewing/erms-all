/*
 * Copyright (c) 2017 旭博蓝凌.Co.Ltd. All rights reserved.
 */

package com.xblltech;


import com.xblltech.entity.Course;
import com.xblltech.entity.Region;
import com.xblltech.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

/**
 * @author ZHANG Yi
 */
@SpringBootApplication
public class DataApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DataApplication.class);
        UserRepository userRepository = context.getBean(UserRepository.class);
        List<Course> all = userRepository.findAll();
        System.out.println(all);
    }
}
