package com.example.home.wiantiattack;

/**
 * Created by ghost on 9/18/16.
 */
public class Detectors {

    String[] wifiList;
    String connectedWifi;
    EvilTwinDetector twindetector;

    public Detectors(String[] WiFiList, String ConnectedWifi){
        wifiList = WiFiList;
        connectedWifi=ConnectedWifi;
        twindetector = new EvilTwinDetector(wifiList,connectedWifi);
    }

    public void update(){
        twindetector.CheckSSIDs();

    }

}
