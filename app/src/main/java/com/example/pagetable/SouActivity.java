package com.example.pagetable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.example.pagetable.base.ActivityBase;
import com.example.pagetable.base.BaseParsenter;

public class SouActivity extends ActivityBase {

    private RecyclerView souRel;
    private DelegateAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_sou;
    }

    @Override
    protected void initDate() {

    }

    @Override
    protected void initView() {
        souRel = findViewById(R.id.sou_rel);
        VirtualLayoutManager manager = new VirtualLayoutManager(this);
        RecyclerView.RecycledViewPool pool = new RecyclerView.RecycledViewPool();
        souRel.setRecycledViewPool(pool);
        pool.setMaxRecycledViews(0, 10);

        //搜索框

        adapter = new DelegateAdapter(manager, false);
        souRel.setLayoutManager(manager);
        souRel.setAdapter(adapter);
    }

    @Override
    protected BaseParsenter add() {
        return new BaseParsenter();
    }
}