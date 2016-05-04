package com.example.visarsmaja.appsrvclient;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class kamera extends ActionBarActivity {

    private static Button buttonrec;
    private static Button buttonpl;
    private  VideoView videorp;
    private int ACTIVITY_KAMERA = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kamera);

        buttonrec = (Button) findViewById(R.id.buttonrec);
        buttonpl = (Button) findViewById(R.id.buttonpl);
        videorp = (VideoView) findViewById(R.id.videorp);


        buttonrec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent playVideo = new Intent();
                playVideo.setAction(MediaStore.ACTION_VIDEO_CAPTURE);

                startActivityForResult(playVideo, ACTIVITY_KAMERA);

            }
        });


        buttonpl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                videorp.start();
            }
        });


    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){


        if(requestCode == ACTIVITY_KAMERA && resultCode == RESULT_OK){

            Uri videoUri = data.getData();
            videorp.setVideoURI(videoUri);
        }
    }




}
