package com.example.home.wiantiattack;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.Log;

import java.util.Objects;
import java.util.Timer;

/**
 * Created by home on 9/17/16.
 */
public class EvilTwinDetector {

   private String[] _wifis;
   private String _currentESSID;

    public EvilTwinDetector(String[] WIFIS, String CurrentESSID) {
        _wifis = WIFIS;
        _currentESSID=CurrentESSID;
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public void CheckSSIDs(){
        for (int i=1;i< _wifis.length;i++) {
            if (Objects.equals(_currentESSID, WifiScanReceiver.getESSID(_wifis[i]))) {
                Log.d("testing", "Evil twin detected");
            }

        }

    }

}
