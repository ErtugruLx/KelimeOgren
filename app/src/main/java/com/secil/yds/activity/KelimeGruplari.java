package com.secil.yds.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.secil.yds.R;

/**
 * Created by root on 5/18/17.
 */

public class KelimeGruplari extends AppCompatActivity {

    private Button noun,adjectives,verbs,adverbs,phrasalverbs,preposition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelimegruplari);

        noun = (Button) findViewById(R.id.butonNoun);
        adjectives = (Button) findViewById(R.id.butonAdjectives);
        verbs = (Button) findViewById(R.id.butonVerbs);
        adverbs = (Button) findViewById(R.id.butonAdverb);
        phrasalverbs = (Button) findViewById(R.id.butonPhrasalVerbs);
        preposition = (Button) findViewById(R.id.butonPreposition);

        noun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KelimeGruplari.this,Kelimeler.class);
                intent.putExtra("grup","1");
                startActivity(intent);
            }
        });

        adjectives.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KelimeGruplari.this,Kelimeler.class);
                intent.putExtra("grup","2");
                startActivity(intent);
            }
        });

        verbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KelimeGruplari.this,Kelimeler.class);
                intent.putExtra("grup","3");
                startActivity(intent);
            }
        });

        adverbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KelimeGruplari.this,Kelimeler.class);
                intent.putExtra("grup","4");
                startActivity(intent);
            }
        });

        phrasalverbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KelimeGruplari.this,Kelimeler.class);
                intent.putExtra("grup","5");
                startActivity(intent);
            }
        });

        preposition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KelimeGruplari.this,Kelimeler.class);
                intent.putExtra("grup","6");
                startActivity(intent);
            }
        });



    }
}