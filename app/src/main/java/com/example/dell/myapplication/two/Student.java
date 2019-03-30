package com.example.dell.myapplication.two;

import com.example.dell.myapplication.one.User;

import javax.inject.Inject;

/**
 * create by lizejun
 * date 2018/7/9
 */
public class Student {
   private User user;
   private String grade;

    @Inject
    public Student(User user ) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getGrade() {
        return grade==null?"初三":grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
