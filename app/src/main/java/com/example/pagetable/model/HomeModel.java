package com.example.pagetable.model;


import com.example.pagetable.contract.Contract;
import com.example.pagetable.util.NetCallBack;
import com.example.pagetable.util.RetrofitUtil;

public class HomeModel implements Contract.InModel {
    @Override
    public <T> void getModel(String url, NetCallBack<T> callBack) {
        RetrofitUtil.getRetrofitUtil().get(url,callBack);
    }
}
