package com.example.pagetable.fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.pagetable.R;
import com.example.pagetable.adatper.BannerSingleAdatper;
import com.example.pagetable.adatper.SouSingleAdatper;
import com.example.pagetable.base.FragmentBase;
import com.example.pagetable.bean.ListBean;
import com.example.pagetable.contract.Contract;
import com.example.pagetable.presenter.HomePresenter;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends FragmentBase<HomePresenter> implements Contract.InView {

    private RecyclerView rel;
    private DelegateAdapter adapter;
    private SouSingleAdatper souSingleAdatper;
    private ArrayList<ListBean.DataBean.BannerBean> bannerlist;


    @Override
    protected HomePresenter getfrag() {
        return new HomePresenter(this);
    }

    protected void initDate() {
        present.getDate();
    }

    protected void initView(View view) {
        rel = view.findViewById(R.id.home_rel);
        VirtualLayoutManager manager = new VirtualLayoutManager(getActivity());
        RecyclerView.RecycledViewPool pool = new RecyclerView.RecycledViewPool();
        rel.setRecycledViewPool(pool);
        pool.setMaxRecycledViews(0, 10);


        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        singleLayoutHelper.setItemCount(2);// 设置布局里Item个数
        singleLayoutHelper.setPadding(1, 1, 1, 1);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        singleLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        singleLayoutHelper.setAspectRatio(1);// 设置设置布局内每行布局的宽与高的比
        souSingleAdatper = new SouSingleAdatper(getActivity(),singleLayoutHelper);
        bannerlist = new ArrayList<>();
        BannerSingleAdatper bannerSingleAdatper = new BannerSingleAdatper(getActivity(), singleLayoutHelper, this.bannerlist);

        adapter = new DelegateAdapter(manager, true);
        adapter.addAdapter(souSingleAdatper);//第一行
        adapter.addAdapter(bannerSingleAdatper);//第二行
        rel.setLayoutManager(manager);
        rel.setAdapter(adapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void getBean(Object object) {
        ListBean listBean= (ListBean) object;
        List<ListBean.DataBean.BannerBean> banner = listBean.getData().getBanner();
        bannerlist.addAll(banner);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void getError(String string) {

    }
}