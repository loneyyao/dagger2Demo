package com.example.dell.myapplication.four;

import com.example.dell.myapplication.MainActivity;

import dagger.Component;

/**
 * create by lizejun
 * date 2018/7/31
 */

@Component(modules = MyModule.class)
public interface AppComponent {
 void inject(MainActivity mainActivity);
}
