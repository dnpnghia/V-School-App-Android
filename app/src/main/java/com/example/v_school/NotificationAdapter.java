package com.example.v_school;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NotificationAdapter extends
        RecyclerView.Adapter<NotificationAdapter.ViewHolder> {



    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView maSptextview;
        public TextView giaTientextview;


        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            maSptextview = (TextView) itemView.findViewById(R.id.txtShowThongBao);
            giaTientextview = (TextView) itemView.findViewById(R.id.txtShowNgayGui);

        }
    }



    // Store a member variable for the contacts
    private List<Notification> mProducts;

    // Pass in the contact array into the constructor
    public NotificationAdapter(List<Notification> products) {
        mProducts = products;
    }
    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public NotificationAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_activity_7, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(NotificationAdapter.ViewHolder holder, int position) {
        // Get the data model based on position
        Notification products = mProducts.get(position);

        // Set item views based on your views and data model
        TextView textView = holder.maSptextview;
        textView.setText("Thông báo: " + products.getMessage());
        TextView textView2 = holder.giaTientextview;
        textView2.setText("Ngày gửi: " + products.getDay());


    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mProducts.size();
    }


}