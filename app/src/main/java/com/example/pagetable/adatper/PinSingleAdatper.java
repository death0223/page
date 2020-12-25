package com.example.pagetable.adatper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.pagetable.R;


public class PinSingleAdatper extends DelegateAdapter.Adapter {

    private Context context;
    private SingleLayoutHelper singleHelper;


    public PinSingleAdatper(Context context, SingleLayoutHelper singleHelper) {
        this.context = context;
        this.singleHelper = singleHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_pin, parent, false);
        return new PinHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }


    class PinHolder extends RecyclerView.ViewHolder {
        private TextView pin;
        public PinHolder(@NonNull View itemView) {
            super(itemView);
            pin = itemView.findViewById(R.id.pin);
        }
    }
}
