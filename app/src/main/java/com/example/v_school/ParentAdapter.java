package com.example.v_school;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ParentAdapter extends RecyclerView.Adapter<ParentAdapter.ViewHolder> {
    List<Account> parentList;
    Context c;
    ArrayList<Account> checkedParents = new ArrayList<>();

    public ParentAdapter(List<Account> parentList) {
        this.parentList = parentList;
    }

    public ParentAdapter(List<Account> parentList, Context context) {
        this.parentList = parentList;
        this.c = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contectView = inflater.inflate(R.layout.item_parent, parent, false);
        ViewHolder viewHolder = new ViewHolder(contectView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Account account = parentList.get(position);
        holder.username.setText(String.format("Tên: " + account.getUsername()));
        holder.phone.setText(String.format("SĐT: " + account.getPhone()));
        holder.address.setText(String.format("Địa chỉ: " + account.getAddress()));
        // checked box
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                CheckBox checkBox = (CheckBox) v;
                //check if checked or not
                if (checkBox.isChecked()) {
                    checkedParents.add(parentList.get(pos));
                } else if (!checkBox.isChecked()) {
                    checkedParents.remove(parentList.get(pos));
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return parentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView username, phone, address;
        public CheckBox checkBox_parent;
        ItemClickListener itemClickListener;

        public ViewHolder(View itemView) {
            super(itemView);
            username = (TextView) itemView.findViewById(R.id.txt_username);
            phone = (TextView) itemView.findViewById(R.id.txt_phone);
            address = (TextView) itemView.findViewById(R.id.txt_address);
            checkBox_parent = (CheckBox) itemView.findViewById(R.id.checkbox_parent);

            checkBox_parent.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            this.itemClickListener.onItemClick(v, getLayoutPosition());
        }

        public void setItemClickListener(ItemClickListener ic) {
            this.itemClickListener = ic;
        }
    }

    interface ItemClickListener {
        void onItemClick(View v, int pos);
    }
}
