package com.example.dell.myapplication.four;

import dagger.Module;
import dagger.Provides;

/**
 * create by lizejun
 * date 2018/7/31
 */
@Module
public class MyModule {
    private IView mainView;

    public MyModule(IView view) {
        mainView = view;
    }

    @Provides
    public MyPresenter provideMyPresenter() {
        return new MyPresenter(mainView);
    }

}
