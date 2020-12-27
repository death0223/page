package com.example.pagetable.adatper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.pagetable.R;
import com.example.pagetable.bean.ListBean;

import java.util.ArrayList;

public class CategorySingleAdatper extends DelegateAdapter.Adapter {

    private Context context;
    private SingleLayoutHelper singleLayoutHelper;
    private ArrayList<ListBean.DataBean.CategoryListBean> title;


    public CategorySingleAdatper(Context context, SingleLayoutHelper singleLayoutHelper, ArrayList<ListBean.DataBean.CategoryListBean> title) {
        this.context = context;
        this.singleLayoutHelper = singleLayoutHelper;
        this.title = title;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_category, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.categoryTv.setText(title.get(position).getName());
        ArrayList<ListBean.DataBean.CategoryListBean.GoodsListBean> list = (ArrayList<ListBean.DataBean.CategoryListBean.GoodsListBean>) title.get(position).getGoodsList();
        CategoryRelAdatper adatper = new CategoryRelAdatper(context, list);
        viewHolder.categoryRel.setLayoutManager(new GridLayoutManager(context,2));
        viewHolder.categoryRel.setAdapter(adatper);
    }

    @Override
    public int getItemCount() {
        if (title.size()>0){
            return title.size();
        }else {
            return 0;
        }
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView categoryTv;
        private RecyclerView categoryRel;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryTv = itemView.findViewById(R.id.category_tv);
            categoryRel = itemView.findViewById(R.id.category_rel);
        }
    }
}
