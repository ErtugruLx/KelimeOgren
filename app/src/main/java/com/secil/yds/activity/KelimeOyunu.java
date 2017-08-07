package com.secil.yds.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.secil.yds.R;
import com.secil.yds.model.Kelime;
import com.secil.yds.util.DBHelper;

import java.util.List;
import java.util.Random;

/**
 * Created by root on 5/19/17.
 */

public class KelimeOyunu extends AppCompatActivity {

    private String kelime = "";
    private String suankiKelime = "";

    private  TextView wordView,randomView;
    private DBHelper dbHelper;
    private List<Kelime> kelimeler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelimeoyunu);


        dbHelper = new DBHelper(KelimeOyunu.this);
        kelimeler = dbHelper.getRandomKelime();

        kelime = kelimeler.get(0).getINGKelime();

        for (int i=0;i<kelime.length();i++) {
            suankiKelime = suankiKelime + "_";
        }

        Random random = new Random();
        int i = random.nextInt(kelime.length()-1);

        harfEkle(kelime.substring(i,i+1));


        wordView = (TextView) findViewById(R.id.word);
        randomView = (TextView) findViewById(R.id.textRandom);

        wordView.setText(kelimeGoruntule());
        randomView.setText(karistir());
    }

    public void yeniTahmin(View view) {

        TextView tahminiText = (TextView) findViewById(R.id.new_letter);

        String yeniTahmin = tahminiText.getText().toString();
        if (!yeniTahmin.equals("")) {
            harfEkleKontrol(yeniTahmin);

            wordView.setText(kelimeGoruntule());
            tahminiText.setText("");

            if (kelimeTamamlandiMi()) {
                Toast.makeText(getApplicationContext(), "Tebrikler.! \nDoğru Tahmin : " + kelimeDondur().toUpperCase() , Toast.LENGTH_LONG).show();
                reset(view);
            }
        }
    }
    public void reset(View view) {
        kelimeler.clear();
        kelime="";
        suankiKelime="";
        dbHelper = new DBHelper(KelimeOyunu.this);
        kelimeler = dbHelper.getRandomKelime();

        kelime = kelimeler.get(0).getINGKelime();

        for (int i=0;i<kelime.length();i++)
            suankiKelime = suankiKelime + "_";

        Random random = new Random();
        int i = random.nextInt(kelime.length()-1);
        harfEkle(kelime.substring(i,i+1));

        wordView.setText(kelimeGoruntule());
        randomView.setText(karistir());
    }

    public String kelimeGoruntule()
    {
        String gecici = "";

        for (int i = 0; i < suankiKelime.length(); i++)
        {
            gecici = gecici + " " + suankiKelime.charAt(i) + " ";
        }

        gecici = gecici.substring(1,gecici.length()-1);
        return gecici;
    }

    void harfEkle(String letter){
        for (int i = 0; i < kelime.length(); i++)
        {
            char c = kelime.toLowerCase().charAt(i);
            if (c == letter.toLowerCase().toCharArray()[0])
            {
                suankiKelime = suankiKelime.substring(0,i) + c + suankiKelime.substring(i+1,suankiKelime.length());
            }
        }
    }

    String karistir(){
        Random random = new Random();
        return scramble( random, kelime );
    }

    public static String scramble( Random random, String kelime )
    {

        char a[] = kelime.toCharArray();

        for( int i=0 ; i< a.length ; i++ )
        {
            int j = random.nextInt(a.length);

            char gecici = a[i];
            a[i] = a[j];
            a[j] = gecici;
        }

        return new String( a );
    }

    public boolean harfEkleKontrol(String harfTahmini) {
        if (karakterKelimeyeEklenebilirMi(harfTahmini) && !harfZatenKelimede(harfTahmini)) {
            harfEkle(harfTahmini);
            return true;
        } else {
            return false;
        }
    }

    boolean kelimeTamamlandiMi(){

        return suankiKelime.toLowerCase().equals(kelime.toLowerCase());
    }

    String kelimeDondur()
    {
        return kelime;
    }



    boolean karakterKelimeyeEklenebilirMi(String harf)
    {
        char c;
        c = harf.toLowerCase().toCharArray()[0];

        for (int i=0;i < kelime.length(); i++)
        {
            char w = kelime.toLowerCase().charAt(i);
            if (w == c)
            {
                return true;
            }
        }
        return false;
    }

    boolean harfZatenKelimede(String harf)
    {
        char c;
        c = harf.toLowerCase().toCharArray()[0];

        for (int i=0;i < suankiKelime.length(); i++)
        {
            char w = suankiKelime.toLowerCase().charAt(i);

            if (w == c)
            {
                return true;
            }
        }
        return false;
    }
}
