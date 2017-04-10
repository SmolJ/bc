package com.example.smolj.bcsmol.Graf;

import com.example.smolj.bcsmol.Helpingclass.*;
import com.example.smolj.bcsmol.files.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;


public class Dijkstra {

    private int time = 600;
    private int number = 0;
    Graph g = new Graph();
    public ArrayList<Integer> ArrayTimes = new ArrayList<>();
    public int cas;
    private int kedy;
    Parser p = new Parser();
    ArrayList<Spoje> ArrayForChecks = new ArrayList<>();
    ArrayList<Hrana> ArrayForCheckh = new ArrayList<>();
    int kod = 0, kod1 = 0, kod2 = 0;
    public int startnode = 0;
    public int secondprice = 0;
    public int finish = 0;
    public int ciel = 0;
    private int timeContinue = 0;
    int lessTimeToMove = 0;

    public Dijkstra(int cas, int kedy, int lessTimeToMove) {
        this.cas = cas;
        this.kedy = kedy;
        this.lessTimeToMove = lessTimeToMove;
    }

    /**
     * matica vrcholov a vah
     */
    private Map<Integer, Map<Integer, Integer>> matica = new HashMap<Integer, Map<Integer, Integer>>();
    /**
     * mapa vzdialenosti
     */
    private Map<Integer, Integer> vzdialenost = new HashMap<Integer, Integer>();

    /**
     * pridaj uzol
     *
     * @param newNode
     */
    private void addNode(int newNode) {

        // na koniec kazdeho zoznamu prida mapovanie node->0
        for (Map<Integer, Integer> row : matica.values()) {
            row.put(newNode, 0);
        }
        // prida novy zoznam dlzky pocetUzlov + 1 plny 0
        Map<Integer, Integer> list = new HashMap<Integer, Integer>();
        for (Integer n : matica.keySet()) {
            list.put(n, 0);
        }
        list.put(newNode, 0);

        matica.put(newNode, list);
    }

    /**
     * odstran uzol
     *
     * @param node
     */
    protected void removeNode(Integer node) {
        matica.remove(node);
        for (Map<Integer, Integer> row : matica.values()) {
            row.remove(node);
        }
    }

    /**
     * pridaj hranu
     *
     * @param node1
     * @param node2
     * @param weight
     */
    public void addEdge(Integer node1, Integer node2, int weight) {
        if (!matica.containsKey(node1)) {
            addNode(node1);
        }
        if (!matica.containsKey(node2)) {
            addNode(node2);
        }

        matica.get(node1).put(node2, weight);

    }

    /**
     * vrati set klucov v matici
     *
     * @return
     */
    public Set<Integer> getNodes() {
        return matica.keySet();
    }

    /**
     * vzdialenost vrcholov
     *
     * @param node1
     * @param node2
     * @return
     */
    private int distance(Integer node1, Integer node2) {
        return matica.get(node1).get(node2);
    }

    /**
     * najde susediace vrcholy
     *
     * @param node
     * @return
     */
    private Set<Integer> findAdjacentNodes(Integer node) {
        Set<Integer> adjacentNodes = new HashSet<Integer>();
        Map<Integer, Integer> s = matica.get(node);
        for (Entry<Integer, Integer> item : s.entrySet()) {
            if (item.getValue() > 0) {
                adjacentNodes.add(item.getKey());
            }
        }
        return adjacentNodes;
    }

    /**
     * najdi najblizsy vrchol
     *
     * @return
     */
    private Integer findNearestNode() {
        int minimum = Integer.MAX_VALUE;
        Integer nearestNode = 0;
        for (Entry<Integer, Integer> entry : vzdialenost.entrySet()) {
            if (entry.getValue() < minimum) {
                minimum = entry.getValue();
                nearestNode = entry.getKey();

            }
        }

        return nearestNode;
    }

    public final void full(int time) {
        Binary b = new Binary();
        g.Vrcholy();
        g.Hrany();
        p.fieldSpoj();
        p.getArraySpoj();
        int kod = 0, kod1 = 0, kod2 = 0;
        for (Hrana h : g.ArrayH) {
            for (Spoje s : h.getArrayS()) {
                findRightConnect(s);
                if (h.getZdroj().getID() != startnode) {
                    if (s.getDepartureTime() != 0 && s.getDepartureTime() - s.getCenahrany() >= time && (kod == kedy || kod1 == kedy || kod2 == kedy)) {
                        addEdge(h.zdroj.getID(), h.ciel.getID(), s.getDepartureTime());
                        break;
                    } else {
                        if (s.getArrivalTime() != 0 && s.getArrivalTime() - s.getCenahrany() >= time && (kod == kedy || kod1 == kedy || kod2 == kedy)) {
                            addEdge(h.zdroj.getID(), h.ciel.getID(), s.getArrivalTime() - s.getCenahrany());
                            break;
                        }
                    }
                } else {
                    if (s.getDepartureTime() - s.getCenahrany() >= time && (kod == kedy || kod1 == kedy || kod2 == kedy)) {
                        addEdge(h.zdroj.getID(), h.ciel.getID(), s.getDepartureTime());
                        break;
                    }
                }
            }
        }
    }

    public void weight(int edgeS, int edgeE, int time) {

        boolean out = false;
        Binary b = new Binary();
        int kod = 0, kod1 = 0, kod2 = 0;

        out:
        for (Hrana h : g.ArrayH) {

            if (h.getZdroj().getID() == edgeS && h.getCiel().getID() == edgeE) {

                // pridat kod na min prestup nieco s S-kom
                for (Spoje s : h.getArrayS()) {
                    findRightConnect(s);
                    if (h.getZdroj().getID() != startnode) {

                        if (s.getDepartureTime() != 0 && s.getDepartureTime() - s.getCenahrany() == time && (kod == kedy || kod1 == kedy || kod2 == kedy)) {
                            matica.get(edgeS).put(edgeE, s.getDepartureTime());
                            break;
                        } else {
                            if (s.getDepartureTime() != 0 && s.getDepartureTime() - s.getCenahrany() >= time + lessTimeToMove && (kod == kedy || kod1 == kedy || kod2 == kedy)) {
                                matica.get(edgeS).put(edgeE, s.getDepartureTime());
                                break;
                            } else {
                                if (s.getArrivalTime() != 0 && s.getArrivalTime() - s.getCenahrany() == time && (kod == kedy || kod1 == kedy || kod2 == kedy)) {
                                    matica.get(edgeS).put(edgeE, s.getArrivalTime() - s.getCenahrany());
                                    break;
                                } else {
                                    if (s.getArrivalTime() != 0 && s.getArrivalTime() - s.getCenahrany() >= time + lessTimeToMove && (kod == kedy || kod1 == kedy || kod2 == kedy)) {
                                        matica.get(edgeS).put(edgeE, s.getArrivalTime() - s.getCenahrany());
                                        break;
                                    }
                                }
                            }
                        }

//                        if (s.getDepartureTime() != 0 && s.getDepartureTime() - s.getCenahrany() >= time && (kod == kedy || kod1 == kedy || kod2 == kedy)) {
//                            matica.get(edgeS).put(edgeE, s.getDepartureTime());
//                            break;
//                        } else {
//
//                            if (s.getArrivalTime() != 0 && s.getArrivalTime() - s.getCenahrany() >= time && (kod == kedy || kod1 == kedy || kod2 == kedy)) {
//                                matica.get(edgeS).put(edgeE, s.getArrivalTime() - s.getCenahrany());
//                                break;
//                            }
//                        }
//
                    } else {
                        if (s.getDepartureTime() - s.getCenahrany() >= time && (kod == kedy || kod1 == kedy || kod2 == kedy)) {
                            matica.get(edgeS).put(edgeE, s.getDepartureTime());
                            break;
                        }

                    }
                }
            }
        }
    }

    /**
     * najde cestu
     *
     * @param sourceNode
     * @param destinationNode
     * @param time
     * @return
     */
    public List<Integer> findPath(Vrchol sourceNode, Vrchol destinationNode, int time) {
        startnode = sourceNode.getID();
        full(time);
        for (Integer node : getNodes()) {
            vzdialenost.put(node, Integer.MAX_VALUE);
        }
        vzdialenost.put(sourceNode.getID(), 0);
        Map<Integer, Integer> predecessors = new HashMap<>();
        Vrchol currentNode = new Vrchol(0, "");

        while ((currentNode.ID = findNearestNode()) > 0) {
            for (Integer adjacentNode : findAdjacentNodes(currentNode.getID())) {
                weight(currentNode.getID(), adjacentNode, time);
                int possiblyBetterDistance = distance(currentNode.getID(), adjacentNode);
                if (possiblyBetterDistance < vzdialenost.get(adjacentNode)) {
                    vzdialenost.put(adjacentNode, possiblyBetterDistance);
                    predecessors.put(adjacentNode, currentNode.getID());
                }
            }
            if (vzdialenost.get(currentNode.getID()) > 0) {
                time = vzdialenost.get(currentNode.getID());
            }
            removeNode(currentNode.getID());
            vzdialenost.remove(currentNode.getID());
        }
        List<Integer> path = new ArrayList<>();
        Integer predecessor = 0;
        Vrchol node = destinationNode;
        path.add(destinationNode.getID());
        while ((predecessor = predecessors.get(node.getID())) != null) {
            path.add(0, predecessor);
            node.setID(predecessor);
        }

        return path;
    }

    public void getIT(int vrchol, int vrchol2) {
        int kod = 0, kod1 = 0, kod2 = 0;
        Spoje spoj = null;
        out:
        for (Hrana h : g.ArrayH) {
            if (vrchol == h.getZdroj().getID() && vrchol2 == h.getCiel().getID()) {
                ArrayForCheckh.add(h);
                for (Spoje s : h.getArrayS()) {
                    findRightConnect(s);
                    if (spoj == null || spoj.getNumberLinka() == s.getNumberLinka()) {
                        if ((s.getDepartureTime() != 0) && (s.getDepartureTime() - s.getCenahrany() == cas) && (kod == kedy || kod1 == kedy || kod2 == kedy) && (s.getCenahrany() != 0)) {
                            ArrayForChecks.add(s);
                            cas = s.getDepartureTime();
                            spoj = s;
                            break out;
                        } else {
                            if (vrchol != startnode) {
                                if (s.getArrivalTime() != 0 && s.getArrivalTime() - s.getCenahrany() == cas && (kod == kedy || kod1 == kedy || kod2 == kedy && s.getCenahrany() != 0)) {
                                    ArrayForChecks.add(s);
                                    cas = s.getArrivalTime();
                                    spoj = s;
                                    break out;
                                }
                            }
                        }
                    }
                    if ((s.getDepartureTime() != 0) && (s.getDepartureTime() - s.getCenahrany() >= cas + lessTimeToMove) && (kod == kedy || kod1 == kedy || kod2 == kedy) && (s.getCenahrany() != 0)) {
                        ArrayForChecks.add(s);
                        cas = s.getDepartureTime();
                        spoj = s;
                        break out;
                    } else {
                        if (vrchol != startnode) {
                            if (s.getArrivalTime() != 0 && s.getArrivalTime() - s.getCenahrany() >= cas + lessTimeToMove && (kod == kedy || kod1 == kedy || kod2 == kedy && s.getCenahrany() != 0)) {
                                ArrayForChecks.add(s);
                                cas = s.getArrivalTime();
                                spoj = s;
                                break out;
                            }

                        }
                    }
                }

            }

        }
    }

    public void findRightConnect(Spoje s) {
        int kod = 0, kod1 = 0, kod2 = 0;
        for (Spoj sp : p.getArraySpoj()) {
            if (s.getNumberLinka() == sp.getNumberLinka() && s.getNumberSpoj() == sp.getNumberSpoja()) {
                kod = sp.getCode1();
                kod1 = sp.getCode2();
                kod2 = sp.getCode3();
                break;
            }
        }
    }

    public void rotate(ArrayList<Spoje> aListConnect) {

        secondprice = 0;
        int finish = 0;
        int changetimeifzero = 0;
        int ciel = 0;
        for (int i = (aListConnect.size() - 2); i >= 0; i--) {
            if (aListConnect.get(i + 1).getDepartureTime() != 0) {
                secondprice = aListConnect.get(i + 1).getDepartureTime() - aListConnect.get(i + 1).getCenahrany();
            }
            if (aListConnect.get(i + 1).getArrivalTime() != 0) {
                secondprice = aListConnect.get(i + 1).getArrivalTime() - aListConnect.get(i + 1).getCenahrany();
            }
            if (aListConnect.get(i).getDepartureTime() != secondprice && aListConnect.get(i).getDepartureTime() != 0 || aListConnect.get(i).getArrivalTime() != secondprice && aListConnect.get(i).getArrivalTime() != 0) {
                int zdroj = 0;
                for (Hrana h : g.ArrayH) {
                    if (i == 0) {
                        zdroj = startnode;
                        ciel = aListConnect.get(i).getNumberZastavka();
                    } else {
                        zdroj = aListConnect.get(i - 1).getNumberZastavka();
                        ciel = aListConnect.get(i).getNumberZastavka();
                    }

                    if (zdroj == h.getZdroj().getID() && ciel == h.getCiel().getID()) {
                        for (Spoje s : h.getArrayS()) {
                            findRightConnect(s);
                            if (aListConnect.get(i + 1).getArrivalTime() != 0) {
                                secondprice = aListConnect.get(i + 1).getArrivalTime() - aListConnect.get(i + 1).getCenahrany();
                            }
                            if (aListConnect.get(i + 1).getDepartureTime() != 0) {
                                secondprice = aListConnect.get(i + 1).getDepartureTime() - aListConnect.get(i + 1).getCenahrany();
                            }
                            if (s.getDepartureTime() == secondprice && (kod == kedy || kod1 == kedy || kod2 == kedy)) {
                                aListConnect.set(i, s);
                                if (s.getNumberSpoj() == aListConnect.get(i + 1).getNumberSpoj()) {
                                    break;
                                }
                            }
                            if (aListConnect.get(i + 1).getDepartureTime() != 0) {
                                finish = aListConnect.get(i + 1).getDepartureTime() - aListConnect.get(i + 1).getCenahrany();
                            }
                            if (aListConnect.get(i + 1).getArrivalTime() != 0) {
                                finish = aListConnect.get(i + 1).getArrivalTime() + aListConnect.get(i + 1).getCenahrany();
                            }
                            if (s.getDepartureTime() > finish || s.getArrivalTime() > finish) {
                                break;
                            }
                        }
                    }
                }
            }
        }
        if (timeContinue != aListConnect.get(0).getDepartureTime() - aListConnect.get(0).getCenahrany()) {
            timeContinue = aListConnect.get(0).getDepartureTime() - aListConnect.get(0).getCenahrany();
        } else {
            timeContinue = aListConnect.get(0).getArrivalTime() - aListConnect.get(0).getCenahrany();
        }
    }

    public void show() {
        rotate(ArrayForChecks);
        int ArDep = 0;
        int ArDepEdge = 0;
        for (Hrana h : ArrayForCheckh) {
            for (Spoje check : ArrayForChecks) {
                if (h.getCiel().getID() == check.getNumberZastavka()) {

                    if (check.getDepartureTime() != check.getDepartureTime() - check.getCenahrany()) {
                        ArDep = check.getDepartureTime();
                        ArDepEdge = check.getDepartureTime() - check.getCenahrany();
                    } else {
                        ArDep = check.getArrivalTime() + check.getCenahrany();
                        ArDepEdge = check.getArrivalTime();
                    }

                    System.out.print(" z " + h.zdroj.getNazov() + "  na " + h.getCiel().getNazov());
                    System.out.println(" cislo: " + h.getZdroj().getID() + " cislo: " + h.getCiel().getID());
                    System.out.println(" v case : " + ArDepEdge + " dorazis v case: " + ArDep);
                    System.out.println(" linkou " + check.getNumberLinka() + " spojom: " + check.getNumberSpoj() + " cena hrany: " + check.getCenahrany());
                    System.out.println("__________________________________________");

                }
            }
        }
        ArrayForCheckh.clear();
        ArrayForChecks.clear();

    }

    public int getTimeContinue() {
        return timeContinue;
    }

    public void setCas(int cas) {
        this.cas = cas;
    }

}
