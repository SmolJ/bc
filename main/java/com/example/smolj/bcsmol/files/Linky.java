package com.example.smolj.bcsmol.files;


public class Linky {

    int numberLinka = 0;
    int numberTarifa = 0;
    String rezerva = "";
    int numberZastavka = 0;
    String code1 = "";
    String code2 = "";
    String code3 = "";

    public Linky(int numberLinka, int numberTarifa, String rezerva, int numberZastavka , String code1, String code2, String code3) {
        this.numberLinka = numberLinka;
        this.numberTarifa = numberTarifa;
        this.rezerva = rezerva;
        this.numberZastavka = numberZastavka;
        this.code1 = code1;
        this.code2 = code2;
        this.code3 = code3;
    }

    @Override
    public String toString() {
        return "Linky{" + "numberLinka=" + numberLinka + ", numberTarifa=" + numberTarifa + ", rezerva=" + rezerva + ", numberZastavka=" + numberZastavka + ", code1=" + code1 + ", code2=" + code2 + ", code3=" + code3 + '}';
    }

    public void setNumberLinka(int numberLinka) {
        this.numberLinka = numberLinka;
    }

    public void setNumberTarifa(int numberTarifa) {
        this.numberTarifa = numberTarifa;
    }

    public void setRezerva(String rezerva) {
        this.rezerva = rezerva;
    }

    public void setNumberZastavka(int numberZastavka) {
        this.numberZastavka = numberZastavka;
    }

    public void setCode1(String code1) {
        this.code1 = code1;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    public void setCode3(String code3) {
        this.code3 = code3;
    }

    public int getNumberLinka() {
        return numberLinka;
    }

    public int getNumberTarifa() {
        return numberTarifa;
    }

    public String getRezerva() {
        return rezerva;
    }

    public int getNumberZastavka() {
        return numberZastavka;
    }

    public String getCode1() {
        return code1;
    }

    public String getCode2() {
        return code2;
    }

    public String getCode3() {
        return code3;
    }



}
