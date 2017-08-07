package com.secil.yds.model;

// Uygulama İçerisinde Kelimeleri Rahat Yönetebilmek İçin Model Oluşturuldu.

public class Kelime{

    private int id,grup,seviye;
    private String INGKelime,TRKelime,INGKelimeEs,INGKelimeZit,INGKelimeCumle,TRKeliemeCumle;

    public Kelime(){

    }

    public Kelime(int id, int grup, int seviye, String ingKelime, String trKelime, String ingKelimeEs, String ingKelimeZit, String ingKelimeCumle, String trKeliemeCumle){
        this.id = id;
        this.grup = grup;
        this.seviye = seviye;
        this.INGKelime = ingKelime;
        this.TRKelime = trKelime;
        this.INGKelimeEs = ingKelimeEs;
        this.INGKelimeZit = ingKelimeZit;
        this.INGKelimeCumle = ingKelimeCumle;
        this.TRKeliemeCumle = trKeliemeCumle;
    }

    public Kelime( int grup, int seviye, String ingKelime, String trKelime, String ingKelimeEs, String ingKelimeZit, String ingKelimeCumle, String trKeliemeCumle) {
        this.grup = grup;
        this.seviye = seviye;
        this.INGKelime = ingKelime;
        this.TRKelime = trKelime;
        this.INGKelimeEs = ingKelimeEs;
        this.INGKelimeZit = ingKelimeZit;
        this.INGKelimeCumle = ingKelimeCumle;
        this.TRKeliemeCumle = trKeliemeCumle;
    }

    public void setGrup(int grup) {
        this.grup = grup;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setINGKelime(String INGKelime) {
        this.INGKelime = INGKelime;
    }

    public void setINGKelimeCumle(String INGKelimeCumle) {
        this.INGKelimeCumle = INGKelimeCumle;
    }

    public void setINGKelimeEs(String INGKelimeEs) {
        this.INGKelimeEs = INGKelimeEs;
    }

    public void setINGKelimeZit(String INGKelimeZit) {
        this.INGKelimeZit = INGKelimeZit;
    }

    public void setSeviye(int seviye) {
        this.seviye = seviye;
    }

    public void setTRKeliemeCumle(String TRKeliemeCumle) {
        this.TRKeliemeCumle = TRKeliemeCumle;
    }

    public void setTRKelime(String TRKelime) {
        this.TRKelime = TRKelime;
    }

    public int getGrup() {
        return grup;
    }

    public int getId() {
        return id;
    }

    public int getSeviye() {
        return seviye;
    }

    public String getINGKelime() {
        return INGKelime;
    }

    public String getINGKelimeCumle() {
        return INGKelimeCumle;
    }

    public String getINGKelimeEs() {
        return INGKelimeEs;
    }

    public String getINGKelimeZit() {
        return INGKelimeZit;
    }

    public String getTRKeliemeCumle() {
        return TRKeliemeCumle;
    }

    public String getTRKelime() {
        return TRKelime;
    }

}
