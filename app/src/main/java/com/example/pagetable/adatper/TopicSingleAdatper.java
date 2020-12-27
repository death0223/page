package com.example.pagetable.adatper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.pagetable.R;
import com.example.pagetable.bean.ListBean;

import java.util.ArrayList;

public class TopicSingleAdatper extends DelegateAdapter.Adapter {

    private Context context;
    private ArrayList<ListBean.DataBean.TopicListBean> list;
    private SingleLayoutHelper singleLayoutHelper;
    private RecyclerView topicRel;

    public TopicSingleAdatper(Context context, ArrayList<ListBean.DataBean.TopicListBean> list, SingleLayoutHelper singleLayoutHelper) {
        this.context = context;
        this.list = list;
        this.singleLayoutHelper = singleLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_topic, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        topicRel = viewHolder.topicRel;
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        topicRel.setLayoutManager(layoutManager);
        TopicRvAdatper adatper = new TopicRvAdatper(context, list);
        topicRel.setAdapter(adatper);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView topicRel;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            topicRel = itemView.findViewById(R.id.topic_rel);
        }
    }

}
