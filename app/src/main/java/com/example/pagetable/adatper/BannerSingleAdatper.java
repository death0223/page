package com.example.pagetable.adatper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.pagetable.R;
import com.example.pagetable.bean.ListBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class BannerSingleAdatper extends DelegateAdapter.Adapter {

    private Context context;
    private SingleLayoutHelper singleLayoutHelper;
    private ArrayList<ListBean.DataBean.BannerBean> banner;

    public BannerSingleAdatper(Context context, SingleLayoutHelper singleLayoutHelper, ArrayList<ListBean.DataBean.BannerBean> banner) {
        this.context = context;
        this.singleLayoutHelper = singleLayoutHelper;
        this.banner = banner;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_banner, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        viewHolder.matherBanner.setImages(banner);
        viewHolder.matherBanner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                ListBean.DataBean.BannerBean ldb= (ListBean.DataBean.BannerBean) path;
                Glide.with(context).load(ldb.getImage_url()).into(imageView);
            }
        }).start();
    }

    @Override
    public int getItemCount() {
        return 1;
    }



    class ViewHolder extends RecyclerView.ViewHolder {
        private Banner matherBanner;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            matherBanner=itemView.findViewById(R.id.mather_banner);
        }
    }
}
