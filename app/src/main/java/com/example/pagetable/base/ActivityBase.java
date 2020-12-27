package com.example.pagetable.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class ActivityBase<P extends BaseParsenter> extends AppCompatActivity implements BaseView  {

    private P present;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        if (present==null){
            present=add();
            present.atachView(this);
            initView();
            initDate();
        }
    }

    protected abstract int getLayoutId();

    protected abstract void initDate();

    protected abstract void initView();

    protected abstract P add();


}
