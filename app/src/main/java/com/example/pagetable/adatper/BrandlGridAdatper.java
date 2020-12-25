package com.example.pagetable.adatper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.pagetable.R;
import com.example.pagetable.bean.ListBean;

import java.util.ArrayList;

public class BrandlGridAdatper extends DelegateAdapter.Adapter {

    private Context context;
    private GridLayoutHelper gridLayoutHelper;
    private ArrayList<ListBean.DataBean.BrandListBean> brandList;

    public BrandlGridAdatper(Context context, GridLayoutHelper gridLayoutHelper, ArrayList<ListBean.DataBean.BrandListBean> brandList) {
        this.context = context;
        this.gridLayoutHelper = gridLayoutHelper;
        this.brandList = brandList;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_brand, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        ListBean.DataBean.BrandListBean brandListBean = brandList.get(position);
        viewHolder.brandName.setText(brandListBean.getName());
        viewHolder.brandPrice.setText(brandListBean.getFloor_price()+"元起");
        Glide.with(context).load(brandListBean.getPic_url()).into(viewHolder.brandImg);
    }

    @Override
    public int getItemCount() {
        return brandList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView brandImg;
        private TextView brandName;
        private TextView brandPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            brandImg = itemView.findViewById(R.id.brand_img);
            brandName = itemView.findViewById(R.id.brand_name);
            brandPrice = itemView.findViewById(R.id.brand_price);
        }
    }
}
