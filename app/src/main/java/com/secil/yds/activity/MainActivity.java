package com.secil.yds.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.secil.yds.R;

public class MainActivity extends AppCompatActivity {

    //Buton değişkenleri oluşturuldu.
    private Button kelimeGruplari,kelimeListesi,alistirmalar,kelimeEkle,favorilerim,hakkimizda;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Buton değişkenleri tanımlandı.
        kelimeGruplari = (Button) findViewById(R.id.kelimeGruplari);
        kelimeListesi = (Button) findViewById(R.id.kelimeListesi);
        alistirmalar = (Button) findViewById(R.id.alistirmalar);
        kelimeEkle = (Button) findViewById(R.id.kelimeEkle);
        favorilerim = (Button) findViewById(R.id.favorilerim);
        hakkimizda = (Button) findViewById(R.id.hakkimizda);

        //Butonlara click özelliği tanımlandı gitmesi gereken activitylere yönlendirildi.
        kelimeGruplari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,KelimeGruplari.class);
                startActivity(intent);
            }
        });

        kelimeListesi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,KelimeListesi.class);
                startActivity(intent);
            }
        });


        alistirmalar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Alistirmalar.class);
                startActivity(intent);

            }
        });


        kelimeEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,KelimeEkle.class);
                startActivity(intent);
            }
        });


        favorilerim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Favorilerim.class);
                startActivity(intent);
            }
        });

        hakkimizda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Hakkimizda.class);
                startActivity(intent);
            }
        });

    }
}
