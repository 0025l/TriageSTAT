package com.example.proyekbesar;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;

@IgnoreExtraProperties

public class Korban implements Serializable {

    private String nama;
    private String jk;
    private String tempat_tgl;
    private String usia;
    private String Triase;

    private String key;

    public Korban() {}


    public String getNama(){

        return nama;

    }

    public void setNama(String nm) {

        this.nama = nm;

    }

    public String getJk() {

        return jk;

    }

    public void setJk(String jk) {

        this.jk = jk;

    }

    public String getTempat_tgl() {

        return tempat_tgl;

    }

    public void setTempat_tgl(String tgl) {

        this.tempat_tgl = tgl;

    }

    public String getUsia() {

        return usia;

    }

    public void setUsia(String usia) {

        this.usia = usia;

    }

    public String getKey() {

        return key;

    }

    public void setKey(String key) {

        this.key = key;

    }


    public String getkTriase() {

        return Triase;

    }

    public void setkTriase(String kT) {

        this.Triase = kT;

    }

    @Override

    public String toString() {

        return " "+nama+"\n" +
                " "+jk +"\n" +
                " "+tempat_tgl +"\n" +
                " "+usia +"\n" +
                " "+Triase;

    }

    public Korban(String nm, String jk, String tgl,String u,String t){

        nama = nm;
        this.jk = jk;
        tempat_tgl = tgl;
        usia = u;

        Triase = t;
    }

}