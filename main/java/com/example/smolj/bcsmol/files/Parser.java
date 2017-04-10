package com.example.smolj.bcsmol.files;


        import com.example.smolj.bcsmol.files.*;
        import java.util.ArrayList;
        import java.util.Arrays;

public class Parser {

    public Linky L;
    public Zastavky Z;
    public Spoje S;
    public Spoj Sp;
    public READFiles RF = new READFiles();

    String text = "";

    ArrayList<String> field = new ArrayList<>();
    ArrayList<Linky> ArrayL = new ArrayList<>();
    ArrayList<Zastavky> ArrayZ = new ArrayList<>();
    ArrayList<Spoj> ArraySpoj = new ArrayList<>();
    ArrayList<Spoje> ArrayS = new ArrayList<>();
    String field3[] = new String[1000];
    int IDzastavky = 0;
    String menoZastavky = "";

    public Parser() {

    }

    public ArrayList fieldLinky() {

        field = RF.readLinky();

        for (int i = 0; i < field.size(); i++) {
            text = field.get(i);

            try {
                String field2[] = text.split("\"");

                L = new Linky(Integer.parseInt(field2[1]), Integer.parseInt(field2[3]), field2[5], Integer.parseInt(field2[7]), field2[9], field2[11], field2[13]);
                ArrayL.add(L);

            } catch (Exception e) {
                System.err.println("error parsing");

            }

//            for (Linky d : ArrayL) {
//                System.out.println(d);
//
//            }
        }
        return ArrayL;
    }

    public ArrayList fieldZastavky() {

        field = RF.readZastavky();

        for (int i = 0; i < field.size(); i++) {
            text = field.get(i);

            try {
                String field2[] = text.split("\"");

                Z = new Zastavky(Integer.parseInt(field2[1]), field2[3], field2[5], field2[7], field2[9], field2[11], field2[13], field2[15], field2[17], field2[19], field2[21], field2[23]);
                ArrayZ.add(Z);

            } catch (Exception e) {
                System.err.println("error parsing");

            }

//            for (Zastavky d : ArrayZ) {
//                System.out.println(d);
//            }
        }
        return ArrayZ;
    }

    public ArrayList fieldSpoje() {

        field = RF.readSpoje();

        for (int i = 0; i < field.size(); i++) {
            text = field.get(i);

            try {

                String field2[] = text.split("\"");
                for (int j = 0; j < field2.length; j++) {
                    if (field2[j].equals("") || field2[j].equals("<")) {
                        field2[j] = "0";
                    }
                }

                S = new Spoje(Integer.parseInt(field2[1]), Integer.parseInt(field2[3]), Integer.parseInt(field2[5]),
                        Integer.parseInt(field2[7]), field2[9], field2[11], field2[13],
                        Integer.parseInt(field2[15]), Integer.parseInt(field2[17]), Integer.parseInt(field2[19]));
                ArrayS.add(S);

            } catch (Exception e) {
                System.err.println("error parsing");

            }

        }

//            for (Spoje d : ArrayS) {
//                System.out.println(d);
//            }
        return ArrayS;
    }

    public ArrayList fieldSpoj() {

        field = RF.readSpoj();

        for (int i = 0; i < field.size(); i++) {
            text = field.get(i);

            try {

                String field2[] = text.split("\"");
                for (int j = 0; j < field2.length; j++) {
                    if (field2[j].equals("")) {
                        field2[j] = "0";
                    }
                }

                Sp = new Spoj(Integer.parseInt(field2[1]), Integer.parseInt(field2[3]), Integer.parseInt(field2[5]),
                        Integer.parseInt(field2[7]), Integer.parseInt(field2[9]), Integer.parseInt(field2[11]),
                        Integer.parseInt(field2[13]), Integer.parseInt(field2[15]), Integer.parseInt(field2[17]),
                        Integer.parseInt(field2[19]), Integer.parseInt(field2[21]), Integer.parseInt(field2[23]));
                ArraySpoj.add(Sp);

            } catch (Exception e) {
                System.err.println("error parsing");
            }

        }


        return ArraySpoj;
    }



    public ArrayList<Spoj> getArraySpoj() {
        return ArraySpoj;
    }

    public ArrayList<Zastavky> getArrayZ() {
        return ArrayZ;
    }

    public ArrayList<Linky> getArrayL() {
        return ArrayL;
    }

    public ArrayList<Spoje> getArrayS() {
        return ArrayS;
    }

}
