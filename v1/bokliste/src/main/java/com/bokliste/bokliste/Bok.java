package com.bokliste.bokliste;

public class Bok {
    private String tittel;
    private String forfatter;
    private int utgivelsesaar;

    public Bok(String tittel, String forfatter, int utgivelsesaar) {
        this.tittel = tittel;
        this.forfatter = forfatter;
        this.utgivelsesaar = utgivelsesaar;
    }

    public String getTittel(){
        return tittel;
    }
    public void setTittel(String tittel){
        this.tittel = tittel;
    }
    public String getForfatter(){
        return forfatter;
    }
    public void setForfatter(String forfatter){
        this.forfatter = forfatter;
    }
    public int getUtgivelsesaar(){
        return utgivelsesaar;
    }
    public void setUtgivelsesaar(int utgivelsesaar){
        this.utgivelsesaar = utgivelsesaar;
    }
    @Override
    public String toString() {
        return "Bok [tittel=" + tittel + ", forfatter=" + forfatter
                + ", utgivelsesaar=" + utgivelsesaar + "]";
    }
}
