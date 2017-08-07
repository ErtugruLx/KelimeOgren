package com.secil.yds.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.secil.yds.R;
import com.secil.yds.adapter.KelimeAdapter;
import com.secil.yds.model.Kelime;
import com.secil.yds.util.DBHelper;

import java.util.List;

/**
 * Created by root on 5/19/17.
 */

public class Ogrendiklerim extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitiy_ogrendiklerim);

        final ListView customListView = (ListView) findViewById(R.id.list);
        DBHelper dbHelper = new DBHelper(getApplicationContext());

        //Öğrendiklerim olarak işaretlenen tüm kelimeleri dbhelper classına bağlanarak çektik.
        //kelimeler listesine atadık.
        final List<Kelime> kelimeler = dbHelper.getAllKelimeler();
        KelimeAdapter myListAdapter = new KelimeAdapter(Ogrendiklerim.this, kelimeler);
        customListView.setAdapter(myListAdapter);
        //Tüm kelimeleri kelime adapter yardımıyla listview üzerinde listeledik.

        //Listviewe tıklanma olayı ekledik. Tıklanan kelimeye ait bilgileri Kelime Detay Classına Gönderdik.
        customListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long rowId) {
                Bundle args = new Bundle();

                args.putInt("id",kelimeler.get(position).getId());
                args.putInt("grup",kelimeler.get(position).getGrup());
                args.putInt("seviye",kelimeler.get(position).getSeviye());
                args.putString("INGKelime",kelimeler.get(position).getINGKelime());
                args.putString("TRKelime",kelimeler.get(position).getTRKelime());
                args.putString("INGKelimeEs",kelimeler.get(position).getINGKelimeEs());
                args.putString("INGKelimeZit",kelimeler.get(position).getINGKelimeZit());
                args.putString("INGKelimeCumle",kelimeler.get(position).getINGKelimeCumle());
                args.putString("TRKelimeCumle",kelimeler.get(position).getTRKeliemeCumle());

                Intent intent = new Intent(Ogrendiklerim.this,KelimeDetay.class);
                intent.putExtras(args);
                startActivity(intent);
            }
        });
    }
}
