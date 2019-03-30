package com.example.dell.myapplication.three;

import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * create by lizejun
 * date 2018/7/30
 */
@Module
public class SchoolModule {

    private List mList;

    public  SchoolModule(List mList){
        this.mList = mList;
    }

    @Provides
   public Teacher provideTeacher(){
        return new Teacher(mList);
    }
}
