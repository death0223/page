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

public class ChannelGridAdatper extends DelegateAdapter.Adapter {

    private Context context;
    private GridLayoutHelper gridLayoutHelper;
    private ArrayList<ListBean.DataBean.ChannelBean> title;


    public ChannelGridAdatper(Context context, GridLayoutHelper gridLayoutHelper, ArrayList<ListBean.DataBean.ChannelBean> title) {
        this.context = context;
        this.gridLayoutHelper = gridLayoutHelper;
        this.title = title;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_channer, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        ListBean.DataBean.ChannelBean channelBean = title.get(position);
        viewHolder.titleTv.setText(channelBean.getName());
        Glide.with(context).load(channelBean.getIcon_url()).into(viewHolder.titleImg);
    }

    @Override
    public int getItemCount() {
        return title.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView titleImg;
        private TextView titleTv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleImg = itemView.findViewById(R.id.title_img);
            titleTv = itemView.findViewById(R.id.title_tv);
        }
    }
}
