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

public class HotGoodGridAdatper extends DelegateAdapter.Adapter {

    private Context context;
    private GridLayoutHelper gridLayoutHelper;
    private ArrayList<ListBean.DataBean.HotGoodsListBean> hotGoodsListBeans;


    public HotGoodGridAdatper(Context context, GridLayoutHelper gridLayoutHelper, ArrayList<ListBean.DataBean.HotGoodsListBean> hotGoodsListBeans) {
        this.context = context;
        this.gridLayoutHelper = gridLayoutHelper;
        this.hotGoodsListBeans = hotGoodsListBeans;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_hot, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        ListBean.DataBean.HotGoodsListBean listBean = hotGoodsListBeans.get(position);
        viewHolder.hotBrief.setText(listBean.getGoods_brief());
        viewHolder.hotName.setText(listBean.getName());
        viewHolder.hotPrice.setText("￥"+listBean.getRetail_price());
        Glide.with(context).load(listBean.getList_pic_url()).into(viewHolder.hotUrl);
    }

    @Override
    public int getItemCount() {
        return hotGoodsListBeans.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView hotImg;
        private ImageView hotUrl;
        private TextView hotName;
        private TextView hotBrief;
        private TextView hotPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hotImg = itemView.findViewById(R.id.hot_img);
            hotUrl = itemView.findViewById(R.id.hot_url);
            hotName = itemView.findViewById(R.id.hot_name);
            hotBrief = itemView.findViewById(R.id.hot_brief);
            hotPrice = itemView.findViewById(R.id.hot_price);
        }
    }
}
