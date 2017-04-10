package com.example.smolj.bcsmol.Graf;


import com.example.smolj.bcsmol.files.*;
        import java.util.ArrayList;
        import java.util.Collections;
        import java.util.Comparator;
        import java.util.HashMap;

public class Graph {

    Parser p = new Parser();
    Vrchol v;
    Vrchol vp = new Vrchol(0, "");
    Hrana h;
    int link = 14;
    int i;
    int calculateprice = 0, cena = 0;
    Hrana hp = new Hrana(0, vp, vp, 0);
    public ArrayList<Vrchol> ArrayV = new ArrayList<>();
    public ArrayList<Hrana> ArrayH = new ArrayList<>();
    ArrayList<Spoje> ArrayHran = new ArrayList<>();
    Spoje sp;
    int calculatepr = 0;
    int[][] VrcholIdHhran;
    int[] polesmernikov;
    Hrana l = null;
    boolean exist = false;
    Spoje spo = new Spoje(0, 0, 0, 0, "", "", "", 0, 0, 0);
    ArrayList<Spoje> ArrayTestovaci = new ArrayList<>();
    private String nazovzastavky = "";

    public ArrayList Vrcholy() {
        p.fieldZastavky();
        for (Zastavky z : p.getArrayZ()) {
            v = new Vrchol(z.getNumberZastavky(), z.getCloseMesto());
            ArrayV.add(v);
        }

//        System.out.println("Graph.Graph.Vrcholy()"+ArrayV.size());
//        for (Vrchol v : ArrayV) {
//            System.out.print(v.ID + " " + v.Nazov + "\n");
//        }
        return ArrayV;
    }
    int prevTarifne = 1000;

    public ArrayList Hrany() {
        p.fieldSpoje();
        p.fieldZastavky();

        for (Spoje s : p.getArrayS()) {

            cena = s.getDepartureTime();

            findname(s);

            v = new Vrchol(s.getNumberZastavka(), nazovzastavky);
            h = new Hrana(i, vp, v, calculateprice);

            for (Hrana c : ArrayH) {

                if (c.ciel.getID() == h.ciel.ID && c.zdroj.ID == h.zdroj.ID) {
                    exist = true;
                    if (s.getArrivalTime() != 0 || s.getDepartureTime() != 0) {
                        c.ArrayS.add(s);
                    }
                    break;
                }
            }

            if (h.ciel.ID == 0 || h.zdroj.ID == 0) {
                exist = true;

            }
            if (exist == false) {
                if (s.getArrivalTime() != 0 || s.getDepartureTime() != 0) {
                    h.ArrayS.add(s);
                    i++;
                }

                if (s.getNumberSpoj() == prevTarifne) {

                    // calculateprice = cena - calculateprice;
                    calculateprice = calculateprice - calculatepr;
                    if (calculateprice >= 39) {
                        calculateprice -= 40;

                    }

                    //  h.setCena(calculateprice);
                    ArrayH.add(h);

                    if (s.getDepartureTime() != 0) {
                        calculateprice = s.getDepartureTime();
                    } else {
                        calculateprice = s.getArrivalTime();
                    }
                    if (spo.getDepartureTime() != 0) {
                        calculatepr = spo.getDepartureTime();
                    } else {
                        calculatepr = spo.getArrivalTime();
                    }

                    spo = s;

                } else {
                    calculateprice = 0;
                    cena = 0;
                }

                prevTarifne = s.getNumberSpoj();
            }
            if (s.getNumberLinka() == link) {
                vp = v;

            } else {
                vp = new Vrchol(0, "");
            }
            exist = false;
            link = s.getNumberLinka();

        }
//        for (Hrana j : ArrayH) {
//            System.out.println("  " + j.zdroj.getID() + " . " + j.getCiel().getID());
//            System.out.println("  " + j.cena );
////
//        }
        Collections.sort(ArrayH, new EdgesComparatorCiel());
        Collections.sort(ArrayH, new EdgesComparatorZdroj());
        for (Hrana c : ArrayH) {
            Collections.sort(c.ArrayS, new EdgesFieldComparatorLinks());
        }

        initTravelstar();
        setPriceEdge();
        // Collections.sort(h.ArrayS, new EdgesFieldComparatorLinks());
//        for (Hrana h : ArrayH) {
//            System.out.println("______________________________");
//            for (Spoje c : h.ArrayS) {
//
//                System.out.print(c.getNumberLinka() + " " + h.zdroj.getID() + " " + h.ciel.getID() + " " + c.getDepartureTime() + " " + c.getArrivalTime() + "\n");
//            }
//        }
//        for (Hrana c : ArrayH) {
//            System.out.print(c.zdroj.ID + " - " + c.zdroj.Nazov + " .. " + c.ciel.ID + " - " + c.ciel.getNazov() + "\n");
//        }

        return ArrayH;
    }

    public void findname(Spoje s) {

        for (Zastavky z : p.getArrayZ()) {
            if (s.getNumberZastavka() == z.getNumberZastavky()) {
                nazovzastavky = z.getCloseMesto();
                break;
            }
        }

    }

    public void setPriceEdge() {
        Spoje temp = new Spoje(0, 0, 0, 0, "", "", "", 0, 0, 0);
        int price = 0;

        for (Spoje con : p.getArrayS()) {

            if (con.getNumberSpoj() == temp.getNumberSpoj()) {

                if (temp.getDepartureTime() != 0) {

                    if (con.getDepartureTime() == 0) {
                        if (con.getArrivalTime() - temp.getDepartureTime() > 40) {
                            price = con.getArrivalTime() - temp.getDepartureTime() - 40;
                            con.setCenahrany(price);
                        } else {
                            price = con.getArrivalTime() - temp.getDepartureTime();
                            con.setCenahrany(price);
                        }

                        ArrayTestovaci.add(con);

                    } else {
                        if (con.getDepartureTime() - temp.getDepartureTime() > 40) {
                            price = con.getDepartureTime() - temp.getDepartureTime() - 40;
                            con.setCenahrany(price);
                        } else {
                            price = con.getDepartureTime() - temp.getDepartureTime();
                            con.setCenahrany(price);
                        }

                        ArrayTestovaci.add(con);

                    }

                }
            }

//            System.out.println("c" + con.toString());
//            System.out.println("t" + temp.toString());
//            System.out.println("" + price);
            temp = con;

        }
    }

    class EdgesComparatorZdroj implements Comparator<Hrana> {

        @Override
        public int compare(Hrana o1, Hrana o2) {
            int e1 = o1.zdroj.getID();
            int e2 = o2.zdroj.getID();

            if (e1 > e2) {
                return 1;
            } else if (e1 < e2) {
                return -1;
            } else {
                return 0;
            }
        }

    }

    class EdgesComparatorCiel implements Comparator<Hrana> {

        @Override
        public int compare(Hrana o1, Hrana o2) {
            int e1 = o1.ciel.getID();
            int e2 = o2.ciel.getID();

            if (e1 > e2) {
                return 1;
            } else if (e1 < e2) {
                return -1;
            } else {
                return 0;
            }
        }

    }

    class EdgesFieldComparatorLinks implements Comparator<Spoje> {

        @Override
        public int compare(Spoje o1, Spoje o2) {
            int e1;
            int e2;
            if (o1.getDepartureTime() > 0) {
                e1 = o1.getDepartureTime();

            } else {
                e1 = o1.getArrivalTime();

            }
            if (o2.getDepartureTime() > 0) {
                e2 = o2.getDepartureTime();

            } else {
                e2 = o2.getArrivalTime();
            }

            if (e1 > e2) {
                return 1;
            } else if (e1 < e2) {
                return -1;
            } else {
                return 0;
            }
//            } else {
//                int e1 = o1.getArrivalTime();
//                int e2 = o2.getArrivalTime();
//                if (e1 > e2) {
//                    return 1;
//                } else if (e1 < e2) {
//                    return -1;
//                } else {
//                    return 0;
//                }
//            }

        }

    }

    private HashMap<Integer, Integer> pairs = new HashMap();

    public HashMap<Integer, Integer> initTravelstar() {
        Vrchol v, n = new Vrchol(0, "");
        int j = 1;
        for (Hrana h : ArrayH) {
            v = h.getZdroj();
            if (n.getID() != v.getID()) {
                pairs.put(h.getZdroj().getID(), j);
                n = v;
            }
            j++;
        }
        return pairs;
    }

    public int getFromTravelStar(Vrchol v) {
        if (pairs == null) {
            initTravelstar();
        }
        return pairs.get(v.getID());
    }

}
