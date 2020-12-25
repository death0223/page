package com.example.pagetable.base;

import androidx.fragment.app.Fragment;

public class BaseParsenter <V extends BaseView> {
    public V iView;

    public void atachView(V v){
        iView=v;
    }
}
