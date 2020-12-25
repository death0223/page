package com.example.pagetable.adatper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.pagetable.R;
import com.example.pagetable.bean.ListBean;

import java.util.ArrayList;

public class NewGoodGridAdatper extends DelegateAdapter.Adapter {

    private Context context;
    private GridLayoutHelper gridLayoutHelper;
    private ArrayList<ListBean.DataBean.NewGoodsListBean> newGoodsListBeans;

    public NewGoodGridAdatper(Context context, GridLayoutHelper gridLayoutHelper, ArrayList<ListBean.DataBean.NewGoodsListBean> newGoodsListBeans) {
        this.context = context;
        this.gridLayoutHelper = gridLayoutHelper;
        this.newGoodsListBeans = newGoodsListBeans;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_newgood, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        ListBean.DataBean.NewGoodsListBean newGoodsListBean = newGoodsListBeans.get(position);
        viewHolder.newName.setText(newGoodsListBean.getName());
        viewHolder.newPrice.setText("￥"+newGoodsListBean.getRetail_price());
        Glide.with(context).load(newGoodsListBean.getList_pic_url()).into(viewHolder.newImg);
    }

    @Override
    public int getItemCount() {
        return newGoodsListBeans.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView newImg;
        private TextView newName;
        private TextView newPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            newImg = itemView.findViewById(R.id.new_img);
            newName = itemView.findViewById(R.id.new_name);
            newPrice = itemView.findViewById(R.id.new_price);
        }
    }
}
