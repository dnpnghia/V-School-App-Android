package com.example.v_school;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ParentAdapter extends RecyclerView.Adapter<ParentAdapter.ViewHolder> {
    List<Account> parentList;
    OnMyAdapterItemClickListener mListener;

    public ParentAdapter(List<Account> parentList) {
        this.parentList = parentList;
    }

    public ParentAdapter(List<Account> parentList, OnMyAdapterItemClickListener Listener) {
        this.parentList = parentList;
        this.mListener = Listener;
    }

    @Override
    public ParentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contectView = inflater.inflate(R.layout.item_parent, parent, false);
        ParentAdapter.ViewHolder viewHolder = new ParentAdapter.ViewHolder(contectView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ParentAdapter.ViewHolder holder, int position) {
        Account account = parentList.get(position);
        holder.username.setText(String.format("Tên: " + account.getUsername()));
        holder.phone.setText(String.format("SĐT: " + account.getPhone()));
        holder.address.setText(String.format("Địa chỉ: " + account.getAddress()));
//        holder.layoutDetail.setOnClickListener(v -> mListener.onItemClick(account));
    }

    @Override
    public int getItemCount() {
        return parentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView username, phone, address;
        LinearLayout layoutDetail;

        public ViewHolder(View itemView) {
            super(itemView);
            username = (TextView) itemView.findViewById(R.id.txt_username);
            phone = (TextView) itemView.findViewById(R.id.txt_phone);
            address = (TextView) itemView.findViewById(R.id.txt_address);
//            layoutDetail = (LinearLayout) itemView.findViewById(R.id.item_detail);
        }
    }

    interface OnMyAdapterItemClickListener {
        void onItemClick(Account parent);
    }
}
