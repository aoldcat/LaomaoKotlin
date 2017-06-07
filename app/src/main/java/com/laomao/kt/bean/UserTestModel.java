package com.laomao.kt.bean;

import javax.inject.Inject;

/**
 * Created by laomao on 2017/6/2.
 */

public class UserTestModel {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    @Inject
    public UserTestModel(){}

}
