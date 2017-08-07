package com.secil.yds.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.secil.yds.R;
import com.secil.yds.app.AppController;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by root on 5/18/17.
 */

public class KelimeEkle extends AppCompatActivity {

    private ProgressDialog pDialog;
    private SearchableSpinner seviyeSpinner,grupSpinner;
    private int seviye,grup;

    private EditText editTextENG,editTextTR,editTextENGES,editTextENGZIT,editTextENGCumle,editTextTRCumle;
    private Button ekle;
    private String ENG,TR,ENGCUMLE,TRCUMLE,ENGZIT,ENGES;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelimeekle);

        ekle = (Button) findViewById(R.id.ekle);

        editTextENG = (EditText) findViewById(R.id.editTextENG);
        editTextTR = (EditText) findViewById(R.id.editTextTR);
        editTextENGES = (EditText) findViewById(R.id.editTextENGES);
        editTextENGZIT = (EditText) findViewById(R.id.editTextENGZIT);
        editTextENGCumle = (EditText) findViewById(R.id.editTextENGCumle);
        editTextTRCumle = (EditText) findViewById(R.id.editTextTRCumle);



        seviyeSpinner = (SearchableSpinner) findViewById(R.id.seviye);
        seviyeSpinner.setTitle("Seviye Seçiniz");
        seviyeSpinner.setPositiveButton("TAMAM");
        seviyeSpinner.setSelection(0,false);

        ArrayAdapter<String> spinnerSeviyeAdapter = new ArrayAdapter<String>(this, android.R.layout
                .simple_spinner_item,getResources().getStringArray(R.array.seviye));
        seviyeSpinner.setAdapter(spinnerSeviyeAdapter);



        grupSpinner = (SearchableSpinner) findViewById(R.id.grup);
        grupSpinner.setTitle("Grup Seçiniz");
        grupSpinner.setPositiveButton("TAMAM");
        grupSpinner.setSelection(0,false);

        ArrayAdapter<String> spinnerGrupAdapter = new ArrayAdapter<String>(this, android.R.layout
                .simple_spinner_item,getResources().getStringArray(R.array.grup));
        grupSpinner.setAdapter(spinnerGrupAdapter);

        seviyeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                seviye=position+1;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        grupSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                grup=position+1;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!editTextENG.getText().toString().equals("")){
                    if(!editTextTR.getText().toString().equals("")){
                        if(!editTextENGES.getText().toString().equals("")){
                            if(!editTextENGZIT.getText().toString().equals("")){
                                if(!editTextENGCumle.getText().toString().equals("")){
                                    if(!editTextTRCumle.getText().toString().equals("")){

                                        ENG = editTextENG.getText().toString();
                                        TR = editTextTR.getText().toString();
                                        ENGES = editTextENGES.getText().toString();
                                        ENGZIT = editTextENGZIT.getText().toString();
                                        ENGCUMLE = editTextENGCumle.getText().toString();
                                        TRCUMLE = editTextTRCumle.getText().toString();

                                        ekle(ENG,grup,seviye,TR,ENGES,ENGZIT,ENGCUMLE,TRCUMLE);
                                    }else{
                                        Toast.makeText(KelimeEkle.this, "Türkçe Cümle Giriniz.", Toast.LENGTH_SHORT).show();
                                    }
                                }else{
                                    Toast.makeText(KelimeEkle.this, "İngilizce CÜmle Giriniz.", Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                Toast.makeText(KelimeEkle.this, "Zıt Anlam Giriniz.", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(KelimeEkle.this, "Eş Anlam Giriniz.", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(KelimeEkle.this, "Türkçe Kelime Giriniz.", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(KelimeEkle.this, "İngilizce Kelime Giriniz.", Toast.LENGTH_SHORT).show();
                }




            }
        });

    }



    private void ekle(final String ENG,final int grup,final int seviye,final String TR,final String ENGES,final String ENGZIT,final String ENGCUMLE,final String TRCUMLE) {
        String tag_string_req = "kelimeekle";

        pDialog = new ProgressDialog(KelimeEkle.this);
        pDialog.setMessage("Kelime Ekleniyor..");
        pDialog.setCancelable(false);
        pDialog.show();

        StringRequest strReq = new StringRequest(Request.Method.POST,
                "http://34.206.170.244/yds/kelimeEkle.php", new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                pDialogGizle();
                if(response.toString().equals("Successfully Uploaded")){
                    Toast.makeText(KelimeEkle.this, "Kelime Yüklendi.", Toast.LENGTH_SHORT).show();
                    editTextENG.setText("");
                    editTextTR.setText("");
                    editTextTRCumle.setText("");
                    editTextENGCumle.setText("");
                    editTextENGES.setText("");
                    editTextENGZIT.setText("");


                }else{
                    Toast.makeText(KelimeEkle.this, "Hata oluştu.\nTekrar Deneyiniz.", Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();

                pDialogGizle();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("ENG", ENG);
                params.put("grup",String.valueOf(grup));
                params.put("seviye",String.valueOf(seviye));
                params.put("TR", TR);
                params.put("ENGES", ENGES);
                params.put("ENGZIT", ENGZIT);
                params.put("ENGCUMLE", ENGCUMLE);
                params.put("TRCUMLE", TRCUMLE);
                return params;
            }

        };

        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }


    private void pDialogGizle() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }
}