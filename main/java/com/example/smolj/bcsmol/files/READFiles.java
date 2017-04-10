package com.example.smolj.bcsmol.files;

        import android.app.Activity;

        import android.content.Context;
        import android.content.res.AssetManager;

        import java.io.BufferedReader;

        import java.io.FileInputStream;
        import java.io.FileReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayList;



public class READFiles {



    String FILENAMEZastavky = "MHD_ZA//ZASTAVKY.txt";
    String FILENAMEspoje = "MHD_ZA//ZASSPOJE.txt";
    String FILENAMElinky = "MHD_ZA//ZASLINKY.txt";
    String FILENAMEspoj = "MHD_ZA//SPOJE.txt";

               Context cont;

            public ArrayList<String> readZastavky() {

                ArrayList<String> field1 = new ArrayList<>();
                int i = 0;




                BufferedReader br = null;
                FileReader fr = null;

                try {

               //     AssetManager am = cont.getAssets();
                    String sCurrentLine;


              //      br = new BufferedReader(
                      //      new InputStreamReader(am.open(FILENAMEZastavky), "windows-1250"));

                    br = new BufferedReader(
                            new InputStreamReader(new FileInputStream(FILENAMEZastavky), "windows-1250"));

                    while ((sCurrentLine = br.readLine()) != null) {
                field1.add(sCurrentLine);
                i++;
            }
        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null) {
                    br.close();
                }

                if (fr != null) {
                    fr.close();
                }

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }
        return field1;
    }

    public ArrayList<String> readSpoje() {

        ArrayList<String> field2 = new ArrayList<>();
        int i = 0;

        BufferedReader br = null;
        FileReader fr = null;

        try {
         //   AssetManager am = cont.getAssets();
            fr = new FileReader(FILENAMEspoje);
            br = new BufferedReader(fr);

            String sCurrentLine;

         //   br = new BufferedReader(
               //     new InputStreamReader(am.open(FILENAMEspoje), "windows-1250"));
            br = new BufferedReader(
                    new InputStreamReader(new FileInputStream(FILENAMEspoje), "windows-1250"));

            while ((sCurrentLine = br.readLine()) != null) {
                field2.add(sCurrentLine);
                i++;
            }
        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null) {
                    br.close();
                }

                if (fr != null) {
                    fr.close();
                }

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }
        return field2;
    }

    public ArrayList<String> readLinky() {

        ArrayList<String> field3 = new ArrayList<>();
        int i = 0;

        BufferedReader br = null;
        FileReader fr = null;

        try {

            fr = new FileReader(FILENAMElinky);
            br = new BufferedReader(fr);
         //   AssetManager am = cont.getAssets();
            String sCurrentLine;

          //  br = new BufferedReader(
             //       new InputStreamReader(am.open(FILENAMElinky), "windows-1250"));

            br = new BufferedReader(
                    new InputStreamReader(new FileInputStream(FILENAMElinky), "windows-1250"));


            while ((sCurrentLine = br.readLine()) != null) {
                field3.add(sCurrentLine);
                i++;
            }
        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null) {
                    br.close();
                }

                if (fr != null) {
                    fr.close();
                }

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }
        return field3;
    }

    public ArrayList<String> readSpoj() {

        ArrayList<String> field4 = new ArrayList<>();
        int i = 0;

        BufferedReader br = null;
        FileReader fr = null;

        try {
          //  AssetManager am = cont.getAssets();
            fr = new FileReader(FILENAMEspoj);
            br = new BufferedReader(fr);

            String sCurrentLine;

         //   br = new BufferedReader(
            //        new InputStreamReader(am.open(FILENAMEspoj), "windows-1250"));
            br = new BufferedReader(
                    new InputStreamReader(new FileInputStream(FILENAMEspoj), "windows-1250"));

            while ((sCurrentLine = br.readLine()) != null) {
                field4.add(sCurrentLine);
                i++;
            }
        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null) {
                    br.close();
                }

                if (fr != null) {
                    fr.close();
                }

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }
        return field4;
    }

}
