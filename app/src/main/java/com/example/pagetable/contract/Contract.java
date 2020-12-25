package com.example.pagetable.contract;

import com.example.pagetable.base.BaseView;
import com.example.pagetable.util.NetCallBack;

public class Contract {
    public interface InModel{
        <T> void getModel(String url, NetCallBack<T> callBack);
    }
    public interface InPresenter{
        void getDate();
    }

    public interface InView extends BaseView {
        void getBean(Object object);
        void getError(String string);
    }
}
