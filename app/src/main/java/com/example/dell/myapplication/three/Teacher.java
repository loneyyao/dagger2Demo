package com.example.dell.myapplication.three;


import com.example.dell.myapplication.four.IView;

import java.util.List;

/**
 * create by lizejun
 * date 2018/7/30
 */
public class Teacher implements IView{

    public List getmList() {
        return mList;
    }

    public void setmList(List mList) {
        this.mList = mList;
    }

    private List mList;

    public Teacher(List mList) {
        this.mList = mList;
    }



    @Override
    public void updateUI(String result) {

    }
}
