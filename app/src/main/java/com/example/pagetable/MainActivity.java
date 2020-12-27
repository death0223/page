package com.example.pagetable;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pagetable.base.ActivityBase;
import com.example.pagetable.base.BaseParsenter;
import com.example.pagetable.fragment.HomeFragment;

public class MainActivity extends ActivityBase {

    private RadioGroup rg;
    private RadioButton rbHome;
    private RadioButton rbZhuti;
    private RadioButton rbFenlei;
    private RadioButton rbShoping;
    private RadioButton rbMy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initDate();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    protected void initDate() {
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rb_home:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fl,new HomeFragment())
                                .commit();
                        break;
                    case R.id.rb_zhuti:
                        break;
                    case R.id.rb_fenlei:
                        break;
                    case R.id.rb_shoping:
                        break;
                    case R.id.rb_my:
                        break;
                }
            }
        });
    }

    protected void initView() {
        rg = findViewById(R.id.rg);
        rbHome = findViewById(R.id.rb_home);
        rbZhuti = findViewById(R.id.rb_zhuti);
        rbFenlei = findViewById(R.id.rb_fenlei);
        rbShoping = findViewById(R.id.rb_shoping);
        rbMy = findViewById(R.id.rb_my);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl,new HomeFragment())
                .commit();
    }

    @Override
    protected BaseParsenter add() {
        return new BaseParsenter();
    }


}