package com.example.pagetable.presenter;

import com.example.pagetable.base.BaseParsenter;
import com.example.pagetable.bean.ListBean;
import com.example.pagetable.contract.Contract;
import com.example.pagetable.model.HomeModel;
import com.example.pagetable.util.NetCallBack;

public class HomePresenter extends BaseParsenter<Contract.InView> implements Contract.InPresenter {

   private Contract.InView view;
    private final HomeModel model;

    public HomePresenter(Contract.InView view) {
        this.view = view;
        model = new HomeModel();
    }

    @Override
    public void getDate() {
        model.getModel("api/index", new NetCallBack<ListBean>() {
            @Override
            public void onSuccess(ListBean listBean) {
                view.getBean(listBean);
            }
        });
    }
}
