package com.example.home.wiantiattack;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by home on 9/17/16.
 */
public class WifiScanReceiver extends BroadcastReceiver {

    ListView lv;

    WifiManager wifi;
    String wifis[];

    Detectors detectors;


    public WifiScanReceiver(ListView listView, WifiManager wifiManager) {
        lv = listView;
        wifi = wifiManager;


    }

    @TargetApi(Build.VERSION_CODES.KITKAT)

    public void onReceive(Context c, Intent intent) {
        List<ScanResult> wifiScanList = wifi.getScanResults();
        wifis = new String[wifiScanList.size()];
        detectors = new Detectors(wifis,ConnectedWifiSSID());

        for (int i = 0; i < wifiScanList.size(); i++) {
            wifis[i] = ((wifiScanList.get(i)).toString());
        }


        detectors.update();

        lv.setAdapter(new ArrayAdapter<>(c.getApplicationContext(), R.layout.list_item, wifis));


    }

    public static String[] getInfoFromString(String ScanResult) {
        return ScanResult.split(",");
    }

    public static String getESSID(String ScanResult) {

        return getInfoFromString(ScanResult)[0].replaceAll("SSID: ", "");
    }

    public String ConnectedWifiSSID() {
        String currentssid = "none";
        //WifiInfo wifiInfo = this.wifi.getConnectionInfo();
        //if (WifiInfo.getDetailedStateOf(wifiInfo.getSupplicantState()) == NetworkInfo.DetailedState.CONNECTED) {
        currentssid = wifi.getConnectionInfo().getSSID();
        currentssid = currentssid.replaceAll("\"", "");
        //}
        return currentssid;

    }


}
