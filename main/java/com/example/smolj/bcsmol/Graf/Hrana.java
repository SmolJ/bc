package com.example.smolj.bcsmol.Graf;

        import com.example.smolj.bcsmol.files.*;
        import java.util.ArrayList;

/**
 *
 * @author SmolJ
 */
public class Hrana {


    public Vrchol zdroj;
    public Vrchol ciel;
    int ID;
    int cena;

    ArrayList<Spoje> ArrayS = new ArrayList<>();
    ArrayList<Spoje> ArraySameS = new ArrayList<>();

    public Hrana(int ID, Vrchol zdroj, Vrchol ciel , int cena) {
        this.zdroj = zdroj;
        this.ciel = ciel;
        this.ID = ID;
        this.cena = cena;

    }

    public int getCena() {
        return cena;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public void setArrayS(ArrayList<Spoje> ArrayS) {
        this.ArrayS = ArrayS;
    }

    public ArrayList<Spoje> getArraySameS() {
        return ArraySameS;
    }

    public void setArraySameS(ArrayList<Spoje> arraySameS) {
        ArraySameS = arraySameS;
    }

    public ArrayList<Spoje> getArrayS() {
        return ArrayS;
    }

    public int getID() {
        return ID;
    }

    public Vrchol getZdroj() {
        return zdroj;
    }

    public Vrchol getCiel() {
        return ciel;
    }

    public void setZdroj(Vrchol zdroj) {
        this.zdroj = zdroj;
    }

    public void setCiel(Vrchol ciel) {
        this.ciel = ciel;
    }

}
