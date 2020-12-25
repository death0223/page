package com.example.pagetable;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pagetable.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {

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

    private void initDate() {

    }

    private void initView() {
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
}