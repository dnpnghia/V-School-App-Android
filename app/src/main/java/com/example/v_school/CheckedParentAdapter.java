package com.example.v_school;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CheckedParentAdapter extends RecyclerView.Adapter<CheckedParentAdapter.ViewHolder> {
    List<Account> parentList;
    Context c;

    public CheckedParentAdapter(List<Account> parentList) {
        this.parentList = parentList;
    }

    public CheckedParentAdapter(List<Account> parentList, Context context) {
        this.parentList = parentList;
        this.c = context;
    }



    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contectView = inflater.inflate(R.layout.item_checkedparent, parent, false);
        CheckedParentAdapter.ViewHolder viewHolder = new CheckedParentAdapter.ViewHolder(contectView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        Account account = parentList.get(position);
        holder.username.setText(String.format("Tên: " + account.getUsername()));
        holder.phone.setText(String.format("SĐT: " + account.getPhone()));
        holder.address.setText(String.format("Địa chỉ: " + account.getAddress()));
        // checked box
//        holder.setItemClickListener(new ParentAdapter.ItemClickListener() {
//            @Override
//            public void onItemClick(View v, int pos) {
//                CheckBox checkBox = (CheckBox) v;
//                //check if checked or not
//                if (checkBox.isChecked()) {
//                    checkedParents.add(parentList.get(pos));
//                } else if (!checkBox.isChecked()) {
//                    checkedParents.remove(parentList.get(pos));
//                }
//
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return parentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView username, phone, address;
//        public CheckBox checkBox_parent;
        ParentAdapter.ItemClickListener itemClickListener;

        public ViewHolder(View itemView) {
            super(itemView);
            username = (TextView) itemView.findViewById(R.id.txt_username);
            phone = (TextView) itemView.findViewById(R.id.txt_phone);
            address = (TextView) itemView.findViewById(R.id.txt_address);
//            checkBox_parent = (CheckBox) itemView.findViewById(R.id.checkbox_parent);

//            checkBox_parent.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            this.itemClickListener.onItemClick(v, getLayoutPosition());
        }

        public void setItemClickListener(ParentAdapter.ItemClickListener ic) {
            this.itemClickListener = ic;
        }
    }

    interface ItemClickListener {
        void onItemClick(View v, int pos);
    }
}
