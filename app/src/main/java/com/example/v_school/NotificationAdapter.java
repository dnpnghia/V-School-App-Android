package com.example.v_school;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.SanPhamHolder> {
    private List<Notification> sanphamList = new ArrayList<>();
    public NotificationAdapter(List<Notification> sanphamList)
    {
        this.sanphamList = sanphamList;
    }
    private MyOnClickItemListener myOnClickItemListener;
    public void setMyOnClickItemListener(MyOnClickItemListener myOnClickItemListener) {
        this.myOnClickItemListener = myOnClickItemListener;
    }
    @NonNull

    @Override
    public SanPhamHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_activity_7,viewGroup,false);
        return new SanPhamHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SanPhamHolder holder, int position) {
        holder.tvTen.setText(sanphamList.get(position).getTopic());
        holder.tvNgay.setText(sanphamList.get(position).getDay());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myOnClickItemListener.onClick(sanphamList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return sanphamList.size();
    }
    public class SanPhamHolder extends RecyclerView.ViewHolder
    {
        public TextView tvTen;
        public TextView tvNgay;
        public SanPhamHolder(@NonNull View itemView) {
            super(itemView);
            tvTen = itemView.findViewById(R.id.txtTenthongbao);
            tvNgay = itemView.findViewById(R.id.txtNgaythongbao);
        }
    }
}
