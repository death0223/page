package com.example.pagetable.util;

import java.util.HashMap;

public interface UrlInterface {
    <T> void get(String url, NetCallBack callBack);
    <T> void post(String url, NetCallBack callBack);
    <T> void postfor(String url, HashMap<String,String> map, NetCallBack callBack);
}
