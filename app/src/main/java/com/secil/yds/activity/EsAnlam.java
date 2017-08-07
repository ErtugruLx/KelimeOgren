package com.secil.yds.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.secil.yds.R;
import com.secil.yds.model.Kelime;
import com.secil.yds.util.DBHelper;

import java.util.List;

/**
 * Created by root on 5/21/17.
 */

public class EsAnlam extends AppCompatActivity {

    private TextView textENG;
    private EditText editTextEsAnlam;
    private Button tahminEt;
    private List<Kelime> kelimeler;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esanlam);

        //Değişkenler tanımlandı.
        textENG = (TextView) findViewById(R.id.textENG);
        editTextEsAnlam = (EditText) findViewById(R.id.editTextTurkce);
        tahminEt = (Button) findViewById(R.id.tahminEt);

        dbHelper = new DBHelper(getApplicationContext());

        //Öğrenilen Kelimeler Arasından Random 1 Kelime Seçildi.
        kelimeler = dbHelper.getRandomKelime();

        //Seçilen Kelime Ekrana Yazıldı.
        textENG.setText(kelimeler.get(0).getINGKelime());

        tahminEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String trkelime = editTextEsAnlam.getText().toString();

                //Girilen kelime ve sistemde ki kelime küçük harflere çevrildi.
                //matches fonskiyonuyla eşleşip eşleşmediği kontrol edildi.
                //eğer eşleşiyorsa doğru tahmin şeklinde uyarı verdi ve yeni kelimeye geçti.
                //eğer eşleşmiyorsa yanlış tahmin şeklinde uyarı verdi edittexti temizledi.
                if (trkelime.toLowerCase().matches(kelimeler.get(0).getINGKelimeEs().toLowerCase())) {
                    Toast.makeText(EsAnlam.this, "Doğru Tahmin Tebrikler!", Toast.LENGTH_SHORT).show();
                    kelimeler.clear();
                    kelimeler = dbHelper.getRandomKelime();
                    textENG.setText(kelimeler.get(0).getINGKelime());
                    editTextEsAnlam.setText("");
                } else {
                    Toast.makeText(EsAnlam.this, "Yanlış Tahmin!\nTekrar Deneyiniz.", Toast.LENGTH_SHORT).show();
                    editTextEsAnlam.setText("");
                }
            }
        });

    }
}