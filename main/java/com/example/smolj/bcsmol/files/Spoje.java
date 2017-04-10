package com.example.smolj.bcsmol.files;

        import java.util.ArrayList;

/**
 *
 * @author SmolJ
 */
public class Spoje {

    int numberLinka = 0;
    int numberSpoj = 0;
    int numberTarifne = 0;
    int numberZastavka = 0;
    String nastupiste = "";
    String code1 = "";
    String code2 = "";
    int kilometer = 0;
    int arrivalTime = 0;
    int departureTime = 0;
    int cenahrany;

    public Spoje(int numberLinka, int numberSpoj, int numberTarifne, int numberZastavka, String nastupiste,
                 String code1, String code2, int kilometer, int arrivalTime, int departureTime) {
        this.numberLinka = numberLinka;
        this.numberSpoj = numberSpoj;
        this.numberTarifne = numberTarifne;
        this.numberZastavka = numberZastavka;
        this.nastupiste = nastupiste;
        this.code1 = code1;
        this.code2 = code2;
        this.kilometer = kilometer;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    public int getCenahrany() {
        return cenahrany;
    }

    public void setCenahrany(int cenahrany) {
        this.cenahrany = cenahrany;
    }



    public void setNastupiste(String nastupiste) {
        this.nastupiste = nastupiste;
    }




    public String toString() {
        return "Spoj{" + "numberLinka=" + numberLinka + ", numberSpoj=" + numberSpoj
                + ", numberTarifne=" + numberTarifne + ", numberZastavka=" + numberZastavka
                + ", numberNastupiste=" + nastupiste + ", code1=" + code1 + ", code2="
                + code2 + ", kilometer=" + kilometer + ", arrivalTime=" + arrivalTime + ", departureTime=" + departureTime + '}';
    }

    public void setNumberLinka(int numberLinka) {
        this.numberLinka = numberLinka;
    }

    public void setNumberSpoj(int numberSpoj) {
        this.numberSpoj = numberSpoj;
    }

    public void setNumberTarifne(int numberTarifne) {
        this.numberTarifne = numberTarifne;
    }

    public void setNumberZastavka(int numberZastavka) {
        this.numberZastavka = numberZastavka;
    }

    public void setNumberNastupiste(String nastupiste) {
        this.nastupiste = nastupiste;
    }

    public void setCode1(String code1) {
        this.code1 = code1;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    public void setKilometer(int kilometer) {
        this.kilometer = kilometer;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setDepartureTime(int departureTime) {
        this.departureTime = departureTime;
    }

    public int getNumberLinka() {
        return numberLinka;
    }

    public int getNumberSpoj() {
        return numberSpoj;
    }

    public int getNumberTarifne() {
        return numberTarifne;
    }

    public int getNumberZastavka() {
        return numberZastavka;
    }

    public String getNastupiste() {
        return nastupiste;
    }

    public String getCode1() {
        return code1;
    }

    public String getCode2() {
        return code2;
    }

    public int getKilometer() {
        return kilometer;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getDepartureTime() {
        return departureTime;
    }

}
