package com.example.pagetable.adatper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pagetable.R;
import com.example.pagetable.bean.ListBean;

import java.util.ArrayList;


public class CategoryRelAdatper extends RecyclerView.Adapter<CategoryRelAdatper.ViewHolder> {

    private Context context;
    private ArrayList<ListBean.DataBean.CategoryListBean.GoodsListBean> list;


    public CategoryRelAdatper(Context context, ArrayList<ListBean.DataBean.CategoryListBean.GoodsListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_category_rel, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListBean.DataBean.CategoryListBean.GoodsListBean goodsListBean = list.get(position);
        holder.relName.setText(goodsListBean.getName());
        holder.relPrice.setText("￥"+goodsListBean.getRetail_price());
        Glide.with(context).load(goodsListBean.getList_pic_url()).into(holder.relImg);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView relImg;
        private TextView relName;
        private TextView relPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            relImg = itemView.findViewById(R.id.rel_img);
            relName = itemView.findViewById(R.id.rel_name);
            relPrice = itemView.findViewById(R.id.rel_price);
        }
    }
}
