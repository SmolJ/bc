package com.example.smolj.bcsmol.bcjava;

        import com.example.smolj.bcsmol.Graf.*;
        import com.example.smolj.bcsmol.files.*;
        import java.util.ArrayList;


public class bcjava{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Graph g = new Graph();
        Parser p = new Parser();
        p.fieldZastavky();
        ArrayList<Integer> field = new ArrayList<>();
        int obmedzenie = 0;
        int temp = 0;
        int lessTimeToMove = 2;

        String sZastavka = "Fatranská";
        String eZastavka = "Slnečné námestie";
        int cislosz = 0;
        int cisloez = 0;
        int time = 600;
        obmedzenie = 0;
        int zobraz = 1;

//            String sZastavka = "Fatranská";
//        String eZastavka = "Slnečné námestie";
//        int cislosz = 0;
//        int cisloez = 0;
//        int time = 800;
//        obmedzenie = 0;
//        int zobraz = 1;

//        String sZastavka = "Obchodná";
//        String eZastavka = "Hlinská";
//        int cislosz = 0;
//        int cisloez = 0;
//        int time = 600;
//        obmedzenie = 0;
//int zobraz = 2;
//       String sZastavka = "Obchodná";
//        String eZastavka = "Matice slovenskej";
//        int cislosz = 0;
//        int cisloez = 0;
//        int time = 600;
//        obmedzenie=0;
//int zobraz = 3;
        Dijkstra d = new Dijkstra(time, obmedzenie, lessTimeToMove); // cas / obmedzenie

        for (Zastavky s : p.getArrayZ()) {
            if (cislosz == s.getNumberZastavky() || (sZastavka.equals(s.getCloseMesto()))) {
                sZastavka = s.getCloseMesto();
                cislosz = s.getNumberZastavky();
            }
            if (cisloez == s.getNumberZastavky() || (eZastavka.equals(s.getCloseMesto()))) {
                eZastavka = s.getCloseMesto();
                cisloez = s.getNumberZastavky();
            }

        }

        Vrchol V = new Vrchol(cislosz, sZastavka);
        Vrchol R = new Vrchol(cisloez, eZastavka);

        for (int a = 0; a < zobraz; a++) {
            for (Integer entry : d.findPath(V, R, time)) {//19
                field.add(entry);
            }
            for (Integer prem : field) {
                if (temp != 0) {
                    d.getIT(temp, prem);
                }
                temp = prem;
            }
            d.show();
            System.out.println(".......................................");
            System.out.println(".......................................");
            System.out.println(".......................................");
            time = d.getTimeContinue();
            d.setCas(d.getTimeContinue() + 1);
        }
    }
}
