package com.example.smolj.bcsmol.Graf;

        import com.example.smolj.bcsmol.files.*;

        import java.util.ArrayList;

public class Vrchol {

    int ID;
    String Nazov;
    int dist=9999999;
    boolean endy = false;
    Vrchol predchodca;

    public Vrchol(int ID, String Nazov) {
        this.ID = ID;
        this.Nazov = Nazov;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }

    public void setEndy(boolean endy) {
        this.endy = endy;
    }

    public void setPredchodca(Vrchol predchodca) {
        this.predchodca = predchodca;
    }

    public boolean isEndy() {
        return endy;
    }

    public Vrchol getPredchodca() {
        return predchodca;
    }

    public int getDist() {
        return dist;
    }

    public int getID() {
        return ID;
    }

    public String getNazov() {
        return Nazov;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNazov(String Nazov) {
        this.Nazov = Nazov;
    }


}
