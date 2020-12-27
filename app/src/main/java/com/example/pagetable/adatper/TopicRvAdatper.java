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

public class TopicRvAdatper extends RecyclerView.Adapter<TopicRvAdatper.ViewHolder> {

    private Context context;
    private ArrayList<ListBean.DataBean.TopicListBean> list;


    public TopicRvAdatper(Context context, ArrayList<ListBean.DataBean.TopicListBean> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_rv_topic, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListBean.DataBean.TopicListBean topicListBean = list.get(position);
        holder.rvPrice.setText("￥"+topicListBean.getPrice_info()+"元起");
        holder.rvSubtitle.setText(topicListBean.getSubtitle());
        holder.rvTitle.setText(topicListBean.getTitle());
        Glide.with(context).load(topicListBean.getScene_pic_url()).into(holder.rvImg);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView rvImg;
        private TextView rvTitle;
        private TextView rvSubtitle;
        private TextView rvPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rvImg = itemView.findViewById(R.id.rv_img);
            rvTitle = itemView.findViewById(R.id.rv_title);
            rvSubtitle = itemView.findViewById(R.id.rv_subtitle);
            rvPrice = itemView.findViewById(R.id.rv_price);
        }
    }
}
