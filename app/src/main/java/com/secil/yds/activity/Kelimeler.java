package com.secil.yds.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.secil.yds.R;
import com.secil.yds.adapter.KelimeAdapter;
import com.secil.yds.app.AppController;
import com.secil.yds.model.Kelime;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 5/18/17.
 */

public class Kelimeler extends AppCompatActivity {

    private ListView listView;
    private KelimeAdapter adapter;
    private List<Kelime> kelimeList = new ArrayList<Kelime>();

    private String grup,url;
    private int seviye;

    private SearchableSpinner seviyeSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelimeler);

        Bundle args = getIntent().getExtras();
        grup = args.getString("grup");

        seviyeSpinner = (SearchableSpinner) findViewById(R.id.seviye);
        seviyeSpinner.setTitle("Seviye Seçiniz");
        seviyeSpinner.setPositiveButton("TAMAM");

        seviyeSpinner.setSelection(0,false);

        listView = (ListView) findViewById(R.id.list);
        adapter = new KelimeAdapter(getApplicationContext(),kelimeList);
        listView.setAdapter(adapter);
        listView.setFocusable(false);
        seviye=1;

        ArrayAdapter<String> spinnerSeviyeAdapter = new ArrayAdapter<String>(this, android.R.layout
                .simple_spinner_item,getResources().getStringArray(R.array.seviye));
        seviyeSpinner.setAdapter(spinnerSeviyeAdapter);

        seviyeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                seviye=position+1;
                kelimeListele(grup);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //kelimeListele(grup);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long rowId) {
                Bundle args = new Bundle();

                args.putInt("id",kelimeList.get(position).getId());
                args.putInt("grup",kelimeList.get(position).getGrup());
                args.putInt("seviye",kelimeList.get(position).getSeviye());
                args.putString("INGKelime",kelimeList.get(position).getINGKelime());
                args.putString("TRKelime",kelimeList.get(position).getTRKelime());
                args.putString("INGKelimeEs",kelimeList.get(position).getINGKelimeEs());
                args.putString("INGKelimeZit",kelimeList.get(position).getINGKelimeZit());
                args.putString("INGKelimeCumle",kelimeList.get(position).getINGKelimeCumle());
                args.putString("TRKelimeCumle",kelimeList.get(position).getTRKeliemeCumle());

                Intent intent = new Intent(Kelimeler.this,KelimeDetay.class);
                intent.putExtras(args);
                startActivity(intent);
            }
        });
    }

    private void kelimeListele(String grup){
        kelimeList.clear();

        url= "http://34.206.170.244/yds/kelimeCek.php?grup="+grup+"&seviye="+seviye;

        String tag_json_obj = "kelimeListesi";

        final ProgressDialog pDialog = new ProgressDialog(this);
        pDialog.setTitle("Lütfen Bekleyiniz");
        pDialog.setMessage("Kelimeler Yükleniyor..");
        pDialog.setCancelable(false);
        pDialog.show();


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray kelimeler = response.getJSONArray("kelimeler");
                    for (int i = 0; i < kelimeler.length(); i++) {
                        JSONObject kelime = kelimeler.getJSONObject(i);

                        Kelime nesne = new Kelime();

                        nesne.setId(kelime.getInt("id"));
                        nesne.setGrup(kelime.getInt("grup"));
                        nesne.setSeviye(kelime.getInt("seviye"));
                        nesne.setINGKelime(kelime.getString("INGKelime"));
                        nesne.setTRKelime(kelime.getString("TRKelime"));
                        nesne.setINGKelimeEs(kelime.getString("INGKelimeEs"));
                        nesne.setINGKelimeZit(kelime.getString("INGKelimeZit"));
                        nesne.setINGKelimeCumle(kelime.getString("INGKelimeCumle"));
                        nesne.setTRKeliemeCumle(kelime.getString("TRKeliemeCumle"));

                        kelimeList.add(nesne);
                    }
                    adapter.notifyDataSetChanged();

                } catch (JSONException e) {

                    e.printStackTrace();
                }
                pDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("Kelimeler", "Error: " + error.getMessage());
                pDialog.dismiss();

            }
        });
        AppController.getInstance().addToRequestQueue(jsonObjectRequest,tag_json_obj);

    }


}