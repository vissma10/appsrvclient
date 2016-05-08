package com.example.visarsmaja.appsrvclient;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class function extends ActionBarActivity {

    private static Button buttoncam;
    private static Button browser1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function);


        OnClickButtonListener();
        BrowserListener();

        Switch toggle = (Switch) findViewById(R.id.wifi_switch);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    toggleWiFi(true);
                    Toast.makeText(getApplicationContext(), "Wi-Fi Enabled!", Toast.LENGTH_LONG).show();
                } else {
                    toggleWiFi(false);
                    Toast.makeText(getApplicationContext(), "Wi-Fi Disabled!", Toast.LENGTH_LONG).show();
                }
            }
        });



    }





    public void toggleWiFi(boolean status) {
        WifiManager wifiManager = (WifiManager) this
                .getSystemService(Context.WIFI_SERVICE);
        if (status == true && !wifiManager.isWifiEnabled()) {
            wifiManager.setWifiEnabled(true);
        } else if (status == false && wifiManager.isWifiEnabled()) {
            wifiManager.setWifiEnabled(false);
        }
    }


    public void OnClickButtonListener() {

        buttoncam = (Button) findViewById(R.id.buttoncam);
        buttoncam.setOnClickListener(

                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent("com.example.visarsmaja.appsrvclient.kamera");
                        startActivity(intent);


                    }
                }
        );


    }

    public void BrowserListener(){

        browser1 = (Button) findViewById(R.id.browser1);
        browser1.setOnClickListener(

                new View.OnClickListener(){

                   public void onClick(View view){


                           Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://92.60.31.99:8081/"));
                           startActivity(browserIntent);

                   }
                }
        );


    }


}
