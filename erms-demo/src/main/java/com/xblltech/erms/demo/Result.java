/*
 * Copyright (c) 2017 旭博蓝凌.Co.Ltd. All rights reserved.
 */

package com.xblltech.erms.demo;

import java.io.Serializable;

public class Result implements Serializable {


    private int code;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
