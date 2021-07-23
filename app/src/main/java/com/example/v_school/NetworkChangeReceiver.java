package com.example.v_school;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class NetworkChangeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
//        final ConnectivityManager connMgr = (ConnectivityManager) context
//                .getSystemService(Context.CONNECTIVITY_SERVICE);
//
//        final android.net.NetworkInfo wifi = connMgr
//                .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
//
//        final android.net.NetworkInfo mobile = connMgr
//                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
//
//        if (wifi.isAvailable() || mobile.isAvailable()) {
//            // Do something
//
//            Log.d("Network Available ", "Flag No 1");
//        }
        String isOnline = isOnline(context) ? "Bật" : "Tắt";
        Toast.makeText(context,"Kết nối mạng đang "+isOnline,Toast.LENGTH_SHORT).show();
    }
    public boolean isOnline(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        //should check null because in airplane mode it will be null
        return (netInfo != null && netInfo.isConnected());
    }
}
