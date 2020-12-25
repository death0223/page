package com.example.pagetable.util;

import java.util.HashMap;

public interface Interface {
    public <T> void get(String url, NetCallBack callBack);
    public <T> void post(String url, NetCallBack callBack);
    public <T> void formget(String url, HashMap<String,String> map, NetCallBack callBack);
}
