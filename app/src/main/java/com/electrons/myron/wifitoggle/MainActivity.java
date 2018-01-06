package com.electrons.myron.wifitoggle;

import android.app.Fragment;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        boolean b;

        boolean wifiEnabled = false;
        if (wifiManager != null) {
            wifiEnabled = wifiManager.isWifiEnabled();
        }

        if(wifiEnabled) {
            b = wifiManager.setWifiEnabled(false);
            Toast.makeText(this, "WiFi Disabled", Toast.LENGTH_SHORT).show();
        }
        else {
            b = wifiManager.setWifiEnabled(true);
            Toast.makeText(this, "WiFi Enabled", Toast.LENGTH_SHORT).show();
        }

        Log.e("WiFi Toggle","WiFi Toggled:"+b);

        finish();

    }
}
