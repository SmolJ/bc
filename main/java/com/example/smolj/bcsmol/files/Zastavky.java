package com.example.smolj.bcsmol.files;


public class Zastavky {

    int numberZastavky = 0;
    String nameObce = "";
    String partObce = "";
    String closeMesto = "";
    String closeObec = "";
    String nameState = "";
    String code1 = "";
    String code2 = "";
    String code3 = "";
    String code4 = "";
    String code5 = "";
    String code6 = "";

    public Zastavky(int numberZastavky, String nameObce, String partObce, String closeMesto, String closeObec,
                    String nameState, String code1, String code2, String code3, String code4, String code5, String code6) {

        this.numberZastavky = numberZastavky;
        this.nameObce = nameObce;
        this.partObce = partObce;
        this.closeMesto = closeMesto;
        this.closeObec = closeObec;
        this.nameState = nameState;
        this.code1 = code1;
        this.code2 = code2;
        this.code3 = code3;
        this.code4 = code4;
        this.code5 = code5;
        this.code6 = code6;

    }

    @Override
    public String toString() {
        return "Zastavky{" + "numberZastavky=" + numberZastavky + ", nameObce=" + nameObce + ", partObce=" + partObce + ", closeMesto=" + closeMesto + ", closeObec=" + closeObec + ", nameState=" + nameState + ", code1=" + code1 + ", code2=" + code2 + ", code3=" + code3 + ", code4=" + code4 + ", code5=" + code5 + ", code6=" + code6 + '}';
    }

    public void setNumberZastavky(int numberZastavky) {
        this.numberZastavky = numberZastavky;
    }

    public void setNameObce(String nameObce) {
        this.nameObce = nameObce;
    }

    public void setPartObce(String partObce) {
        this.partObce = partObce;
    }

    public void setCloseMesto(String closeMesto) {
        this.closeMesto = closeMesto;
    }

    public void setCloseObec(String closeObec) {
        this.closeObec = closeObec;
    }

    public void setNameState(String nameState) {
        this.nameState = nameState;
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

    public void setCode4(String code4) {
        this.code4 = code4;
    }

    public void setCode5(String code5) {
        this.code5 = code5;
    }

    public void setCode6(String code6) {
        this.code6 = code6;
    }

    public int getNumberZastavky() {
        return numberZastavky;
    }

    public String getNameObce() {
        return nameObce;
    }

    public String getPartObce() {
        return partObce;
    }

    public String getCloseMesto() {
        return closeMesto;
    }

    public String getCloseObec() {
        return closeObec;
    }

    public String getNameState() {
        return nameState;
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

    public String getCode4() {
        return code4;
    }

    public String getCode5() {
        return code5;
    }

    public String getCode6() {
        return code6;
    }



}
