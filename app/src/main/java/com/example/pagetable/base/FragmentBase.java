package com.example.pagetable.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class FragmentBase<P extends BaseParsenter> extends Fragment implements BaseView {
    public  P present;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        if (present==null){
            present=getfrag();
            present.atachView(this);
            initView(view);
            initDate();
        }
        return view;
    }

    protected abstract P getfrag();

    protected abstract void initDate();

    protected abstract void initView(View view);

    protected abstract int getLayoutId();



}
