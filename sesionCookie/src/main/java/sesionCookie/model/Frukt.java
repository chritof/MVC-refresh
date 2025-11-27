package sesionCookie.model;

public class Frukt {

    private int id;
    private String navn;
    private int pris;

    public Frukt(int id, String navn, int pris) {
        this.id = id;
        this.navn = navn;
        this.pris = pris;
    }
    public Frukt() {}

    public int getId() {
        return id;
    }
    public String getNavn() {
        return navn;
    }
    public int getPris() {
        return pris;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setNavn(String navn) {
        this.navn = navn;
    }
    public void setPris(int pris) {
        this.pris = pris;
    }

}
