package com.buttonsNettbutikk.buttonsNettbutikk;

public class Ordelinje {
    private Vare vare;
    private int antall;

    public Ordelinje() {}

    public Ordelinje(Vare vare, int antall) {
        this.vare = vare;
        this.antall = antall;
    }

    public Vare getVare() {
        return vare;
    }
    public void setVare(Vare vare) {
        this.vare = vare;
    }
    public int getAntall() {
        return antall;
    }
    public void setAntall(int antall) {
        this.antall = antall;
    }

    public int getBelop(){
        return vare.getPris() * antall;
    }
}
