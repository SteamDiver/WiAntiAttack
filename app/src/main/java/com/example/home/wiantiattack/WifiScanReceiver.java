package com.example.home.wiantiattack;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

/**
 * Created by home on 9/17/16.
 */
public class WifiScanReceiver extends BroadcastReceiver {

    ListView lv;
    WifiManager wifi;
    String wifis[];

    public WifiScanReceiver(ListView listView, WifiManager wifiManager) {
        lv = listView;
        wifi = wifiManager;
    }

    public void onReceive(Context c, Intent intent) {
        List<ScanResult> wifiScanList = wifi.getScanResults();
        wifis = new String[wifiScanList.size()];

        for (int i = 0; i < wifiScanList.size(); i++) {
            wifis[i] = ((wifiScanList.get(i)).toString());
        }
        lv.setAdapter(new ArrayAdapter<>(c.getApplicationContext(), R.layout.list_item, wifis));
    }

    public String[] getInfoFromString(String ScanResult) {

        return ScanResult.split(",");
    }

    public String getESSID(){
        return null;
    }

    public String ConnectedWifiSSID(Context context) {
        String ssid = "none";
        WifiInfo wifiInfo = wifi.getConnectionInfo();
        if (WifiInfo.getDetailedStateOf(wifiInfo.getSupplicantState()) == NetworkInfo.DetailedState.CONNECTED) {
            ssid = wifiInfo.getSSID();
        }
        return ssid;
    }


}
