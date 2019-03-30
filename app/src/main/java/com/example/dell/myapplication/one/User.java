package com.example.dell.myapplication.one;


import javax.inject.Inject;

/**
 * create by lizejun
 * date 2018/7/5
 */


public class User {
    private String name;
    private String age;

    @Inject
    public User(){}
    public User(String name ,String age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name==null?"wo shi null":name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age==null?"1024 sui":age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
