package sesionCookie.model;

public class Vare {

    private int id;
    private String navn;
    private String beskrivelse;
    private int pris;
    public Vare() {}
    public Vare(int id, String navn, String beskrivelse, int pris) {
        this.id = id;
        this.navn = navn;
        this.beskrivelse = beskrivelse;
        this.pris = pris;
    }
    public int getId() {
        return id;
    }
    public String getNavn() {
        return navn;
    }
    public String getBeskrivelse() {
        return beskrivelse;
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
    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }
    public void setPris(int pris) {
        this.pris = pris;
    }
}
