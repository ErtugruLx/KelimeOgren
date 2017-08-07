package com.secil.yds.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.secil.yds.R;
import com.secil.yds.model.Kelime;
import com.secil.yds.util.DBHelper;

/**
 * Created by root on 5/18/17.
 */

public class KelimeDetay extends AppCompatActivity {

    private TextView textENG,textTR,textES,textZIT,textENGCumle,textTRCumle;
    private Menu menu;
    private DBHelper dbHelper;
    private String ENGKelime,TRKelime,ENGKelimeES,ENGKelimeZIT,ENGKelimeCumle,TRKelimeCumle;
    private int id,grup,seviye;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelimedetay);

        textENG = (TextView) findViewById(R.id.textENG);
        textTR = (TextView) findViewById(R.id.textTR);
        textES = (TextView) findViewById(R.id.textES);
        textZIT = (TextView) findViewById(R.id.textZIT);
        textENGCumle = (TextView) findViewById(R.id.textENGCumle);
        textTRCumle = (TextView) findViewById(R.id.textTRCumle);


        Bundle args = getIntent().getExtras();
        id = args.getInt("id");
        grup = args.getInt("grup");
        seviye = args.getInt("seviye");

        ENGKelime = args.getString("INGKelime");
        TRKelime = args.getString("TRKelime");
        ENGKelimeES = args.getString("INGKelimeEs");
        ENGKelimeZIT = args.getString("INGKelimeZit");
        ENGKelimeCumle = args.getString("INGKelimeCumle");
        TRKelimeCumle = args.getString("TRKelimeCumle");

        textENG.setText(ENGKelime);
        textTR.setText(TRKelime);
        textES.setText(ENGKelimeES);
        textZIT.setText(ENGKelimeZIT);
        textENGCumle.setText(ENGKelimeCumle);
        textTRCumle.setText(TRKelimeCumle);

        dbHelper = new DBHelper(getApplicationContext());
        dbHelper.kelimeEkle(new Kelime(id,grup,seviye
                ,ENGKelime,TRKelime,ENGKelimeES,
                ENGKelimeZIT,ENGKelimeCumle,TRKelimeCumle));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_favori,menu);
        this.menu=menu;

        if(dbHelper.getIDFavori(ENGKelime)==-1){
            menu.getItem(0).setIcon(R.drawable.fav);
        }else{
            menu.getItem(0).setIcon(R.drawable.unfav);
        }

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.favori:
                favori();
                break;
            case android.R.id.home:
                onBackPressed();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void favori(){
        if(dbHelper.getIDFavori(ENGKelime)==-1){
            menu.getItem(0).setIcon(R.drawable.unfav);
            dbHelper.favoriEkle(new Kelime(id,grup,seviye
                    ,ENGKelime,TRKelime,ENGKelimeES,
                    ENGKelimeZIT,ENGKelimeCumle,TRKelimeCumle));

        }else{
            menu.getItem(0).setIcon(R.drawable.fav);
            dbHelper.favoriSil(new Kelime(id,grup,seviye
                    ,ENGKelime,TRKelime,ENGKelimeES,
                    ENGKelimeZIT,ENGKelimeCumle,TRKelimeCumle));
        }


    }

}
