package com.example.dell.myapplication.four;

/**
 * create by lizejun
 * date 2018/7/31
 */
public class MyPresenter implements IPresenter {

    private IView iView;

    public MyPresenter(IView view){
        iView = view;
    }

    @Override
    public void loadData() {
        iView.updateUI("Mvp Update UI " + System.currentTimeMillis());
    }
}
