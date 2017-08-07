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
 * Created by root on 5/18/17.
 */

public class Favorilerim extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitiy_favorilerim);

        final ListView customListView = (ListView) findViewById(R.id.list);
        DBHelper dbHelper = new DBHelper(getApplicationContext());

        final List<Kelime> kelimeler = dbHelper.getFavori();
        KelimeAdapter myListAdapter = new KelimeAdapter(Favorilerim.this, kelimeler);
        customListView.setAdapter(myListAdapter);

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

                Intent intent = new Intent(Favorilerim.this,KelimeDetay.class);
                intent.putExtras(args);
                startActivity(intent);
            }
        });
    }
}