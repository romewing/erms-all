/*
 * Copyright (c) 2017 旭博蓝凌.Co.Ltd. All rights reserved.
 */

package com.xblltech.repository;

import com.xblltech.entity.Course;
import com.xblltech.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ZHANG Yi
 */
public interface UserRepository extends JpaRepository<Course, String>{
}
