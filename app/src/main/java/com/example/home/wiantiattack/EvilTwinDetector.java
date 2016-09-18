package com.example.home.wiantiattack;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import java.util.Objects;

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
        for (int i=1;i< _wifis.length;i++)
            if (Objects.equals(_currentESSID, WifiScanReceiver.getESSID(_wifis[i]))) {
                Log.d("testing", "Evil twin detected");
                Toast toast = Toast.makeText(MainActivity.context, "Evil twin detected!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM, 0, 100);
                toast.show();
                new Notifier(MainActivity.context, "Attention","Найдено две или несколько сетей с одинаковыми именами. Возможна EvilTwin-атака",100);

                
            }

    }

}
