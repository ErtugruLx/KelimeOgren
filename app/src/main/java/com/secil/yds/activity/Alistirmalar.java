package com.secil.yds.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.secil.yds.R;
import com.secil.yds.adapter.KelimeAdapter;
import com.secil.yds.model.Kelime;
import com.secil.yds.util.DBHelper;

import java.util.List;

/**
 * Created by root on 5/18/17.
 */

public class Alistirmalar extends AppCompatActivity {

    private Button ogrendiklerim,turkce,ingilizce,esanlam,zitanlam,kelimeoyunu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alistirmalar);

        ogrendiklerim = (Button) findViewById(R.id.butonOgrendiklerim);
        turkce = (Button) findViewById(R.id.butonTurkce);
        ingilizce = (Button) findViewById(R.id.butonENG);
        esanlam = (Button) findViewById(R.id.butonENGES);
        zitanlam = (Button) findViewById(R.id.butonENGZIT);
        kelimeoyunu = (Button) findViewById(R.id.butonKelime);


        ogrendiklerim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Alistirmalar.this,Ogrendiklerim.class);
                startActivity(intent);
            }
        });

        turkce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Alistirmalar.this,TurkceBul.class);
                startActivity(intent);
            }
        });

        ingilizce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Alistirmalar.this,EngBul.class);
                startActivity(intent);
            }
        });

        esanlam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Alistirmalar.this,EsAnlam.class);
                startActivity(intent);
            }
        });

        zitanlam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Alistirmalar.this,ZitAnlam.class);
                startActivity(intent);
            }
        });

        kelimeoyunu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(Alistirmalar.this,KelimeOyunu.class);
                startActivity(intent);
            }
        });


    }
}