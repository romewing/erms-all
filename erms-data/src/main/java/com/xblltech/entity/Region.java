/*
 * Copyright (c) 2017 旭博蓝凌.Co.Ltd. All rights reserved.
 */

package com.xblltech.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author ZHANG Yi
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "DMHR", name = "REGION")
public class Region implements Serializable {

    @Column(name = "REGION_ID")
    @Id
    private String id;

    @Column(name="REGION_NAME")
    private String name;


}
