package com.secil.yds.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.secil.yds.model.Kelime;

import java.util.ArrayList;
import java.util.List;


// Local Database Olarak SQLite Kullanıldı.
public class DBHelper extends SQLiteOpenHelper {

    //Database ismi ve tablo sabitleri tanımlandı.
    private static final String DATABASE_NAME   = "KelimeOgrenDB";
    private static final String TABLE_KELIMELER = "kelimeler";
    private static final String TABLE_FAVORILER = "favoriler";

    // Yapılandırıcı olarak contexe database atadı
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Uygulama İlk Defa Açıldıysa Tablolar Oluşturulur.
        // Favoriler ve Kelimeler Şeklinde 2 Tablo Sorgusu Hazırlandı.

        String sql = "CREATE TABLE " + TABLE_KELIMELER + "(id INTEGER PRIMARY KEY,INGKelime TEXT,grup TEXT,seviye TEXT," +
                "TRKelime TEXT,INGKelimeEs TEXT,INGKelimeZit TEXT,INGKelimeCumle TEXT,TRKeliemeCumle TEXT" + ")";

        String sqlfav = "CREATE TABLE " + TABLE_FAVORILER + "(id INTEGER PRIMARY KEY,INGKelime TEXT,grup TEXT,seviye TEXT," +
                "TRKelime TEXT,INGKelimeEs TEXT,INGKelimeZit TEXT,INGKelimeCumle TEXT,TRKeliemeCumle TEXT" + ")";

        //Hazırlanan Sorgular Çalıştırıldı ve Tablolar Oluşturuldu.
        db.execSQL(sql);
        db.execSQL(sqlfav);
    }


    // Database Güncellemesi İçin Gerekli Fonskiyon
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_KELIMELER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FAVORILER);
        onCreate(db);
    }

    //Kelime Ekleme Fonksiyonu Kelime Listesini Değişken Olarak Alır.
    public void kelimeEkle(Kelime kelime) {

        //SQLite'ı Veri Yazılacak Şekilde Açar
        SQLiteDatabase db = this.getWritableDatabase();

        //Kelime Listesi İçerisinde Bulunan Veriler Parçalanır ve Setlenir.
        ContentValues values = new ContentValues();
        values.put("INGKelime", kelime.getINGKelime());
        values.put("grup", kelime.getGrup());
        values.put("seviye", kelime.getSeviye());
        values.put("TRKelime", kelime.getTRKelime());
        values.put("INGKelimeEs", kelime.getINGKelimeEs());
        values.put("INGKelimeZit", kelime.getINGKelimeZit());
        values.put("INGKelimeCumle", kelime.getINGKelimeCumle());
        values.put("TRKeliemeCumle", kelime.getTRKeliemeCumle());

        //Daha Önce Aynı Kelime Eklenmiş Mi Kontrolü Yapar.
        int id = getID(kelime.getINGKelime());
        if(id==-1) {
            //Eğer Eklenmemişse Kelime Database Kaydedilir.
            db.insert(TABLE_KELIMELER, null, values);
            db.close();
        }

    }

    public void favoriEkle(Kelime kelime) {

        //SQLite'ı Veri Yazılacak Şekilde Açar
        SQLiteDatabase db = this.getWritableDatabase();

        //Kelime Listesi İçerisinde Bulunan Veriler Parçalanır ve Setlenir.
        ContentValues values = new ContentValues();
        values.put("INGKelime", kelime.getINGKelime());
        values.put("grup", kelime.getGrup());
        values.put("seviye", kelime.getSeviye());
        values.put("TRKelime", kelime.getTRKelime());
        values.put("INGKelimeEs", kelime.getINGKelimeEs());
        values.put("INGKelimeZit", kelime.getINGKelimeZit());
        values.put("INGKelimeCumle", kelime.getINGKelimeCumle());
        values.put("TRKeliemeCumle", kelime.getTRKeliemeCumle());

        //Daha Önce Aynı Kelime Eklenmiş Mi Kontrolü Yapar.
        int id = getIDFavori(kelime.getINGKelime());
        if(id==-1) {
            //Eğer Eklenmemişse Kelime Database Kaydedilir.
            db.insert(TABLE_FAVORILER, null, values);
            db.close();
        }

    }

    public void favoriSil(Kelime kelime) {
        //SQLite'ı Veri Yazılacak Şekilde Açar
        SQLiteDatabase db = this.getWritableDatabase();

        //Kelime Listesi İçerisinde Bulunan Veriler Parçalanır ve Setlenir.
        ContentValues values = new ContentValues();
        values.put("INGKelime", kelime.getINGKelime());
        values.put("grup", kelime.getGrup());
        values.put("seviye", kelime.getSeviye());
        values.put("TRKelime", kelime.getTRKelime());
        values.put("INGKelimeEs", kelime.getINGKelimeEs());
        values.put("INGKelimeZit", kelime.getINGKelimeZit());
        values.put("INGKelimeCumle", kelime.getINGKelimeCumle());
        values.put("TRKeliemeCumle", kelime.getTRKeliemeCumle());

        //Daha Önce Aynı Kelime Favorilere Eklenmiş Mi Kontrolü Yapar.
        int id = getIDFavori(kelime.getINGKelime());
        if(id!=-1) {
            //Eğer Eklenmemişse Kelime Databaseden Silinir.
            db.delete(TABLE_FAVORILER, "INGKelime=?", new String[]{kelime.getINGKelime()});
            db.close();
        }

    }

    //Favoriye Eklenmiş Tüm Kelimeleri Geriye Döndürür.
    public List<Kelime> getFavori() {

        List<Kelime> kelimeler = new ArrayList<Kelime>();
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query(TABLE_FAVORILER, new String[]{"id", "INGKelime", "grup", "seviye", "TRKelime", "INGKelimeEs",
                "INGKelimeZit", "INGKelimeCumle", "TRKeliemeCumle"}, null, null, null, null, null);
        while (cursor.moveToNext()) {
            Kelime kelime = new Kelime();
            kelime.setId(cursor.getInt(0));
            kelime.setINGKelime(cursor.getString(1));
            kelime.setGrup(Integer.parseInt(cursor.getString(2)));
            kelime.setSeviye(Integer.parseInt(cursor.getString(3)));
            kelime.setTRKelime(cursor.getString(4));
            kelime.setINGKelimeEs(cursor.getString(5));
            kelime.setINGKelimeZit(cursor.getString(6));
            kelime.setINGKelimeCumle(cursor.getString(7));
            kelime.setTRKeliemeCumle(cursor.getString(8));
            kelimeler.add(kelime);
        }

        return kelimeler;
    }


    //Öğrenilen Tüm Kelimeleri Listeler.
    public List<Kelime> getAllKelimeler() {
        List<Kelime> kelimeler = new ArrayList<Kelime>();
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query(TABLE_KELIMELER, new String[]{"id", "INGKelime", "grup", "seviye", "TRKelime", "INGKelimeEs",
                "INGKelimeZit", "INGKelimeCumle", "TRKeliemeCumle"}, null, null, null, null, null);
        while (cursor.moveToNext()) {
            Kelime kelime = new Kelime();
            kelime.setId(cursor.getInt(0));
            kelime.setINGKelime(cursor.getString(1));
            kelime.setGrup(Integer.parseInt(cursor.getString(2)));
            kelime.setSeviye(Integer.parseInt(cursor.getString(3)));
            kelime.setTRKelime(cursor.getString(4));
            kelime.setINGKelimeEs(cursor.getString(5));
            kelime.setINGKelimeZit(cursor.getString(6));
            kelime.setINGKelimeCumle(cursor.getString(7));
            kelime.setTRKeliemeCumle(cursor.getString(8));
            kelimeler.add(kelime);
        }

        return kelimeler;
    }

    //  Alıştırmalar Bölümünde ki Oyunlar İçin Öğrenilen
    //  Kelimeler Arasından Random 1 Tanesini Geriye Döndürür.
    public List<Kelime> getRandomKelime() {
        List<Kelime> kelimeler = new ArrayList<Kelime>();
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_KELIMELER+ " ORDER BY RANDOM() LIMIT 1", null);
        while (cursor.moveToNext()) {
            Kelime kelime = new Kelime();
            kelime.setId(cursor.getInt(0));
            kelime.setINGKelime(cursor.getString(1));
            kelime.setGrup(Integer.parseInt(cursor.getString(2)));
            kelime.setSeviye(Integer.parseInt(cursor.getString(3)));
            kelime.setTRKelime(cursor.getString(4));
            kelime.setINGKelimeEs(cursor.getString(5));
            kelime.setINGKelimeZit(cursor.getString(6));
            kelime.setINGKelimeCumle(cursor.getString(7));
            kelime.setTRKeliemeCumle(cursor.getString(8));
            kelimeler.add(kelime);
        }

        return kelimeler;
    }

    //Öğrenilen kelimeler içerisinde girilen kelimenin var olup olmadığını kontrol eder.
    private int getID(String INGKelime){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.query(TABLE_KELIMELER,new String[]{"id"}, "INGKelime =? ",new String[]{INGKelime},null,null,null,null);
        if (c.moveToFirst())
            return c.getInt(c.getColumnIndex("id"));
        return -1;
    }
    //Favoriye eklenmiş kelimeler içerisinde girilen kelimenin var olup olmadığını kontrol eder.
    public int getIDFavori(String INGKelime){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.query(TABLE_FAVORILER,new String[]{"id"}, "INGKelime =? ",new String[]{INGKelime},null,null,null,null);
        if (c.moveToFirst())
            return c.getInt(c.getColumnIndex("id"));
        return -1;
    }
}