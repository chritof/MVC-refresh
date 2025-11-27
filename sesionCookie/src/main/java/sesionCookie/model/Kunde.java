package sesionCookie.model;

public class Kunde {

    private String navn;
    private String tlf;
    private String email;

    public Kunde(String navn, String tlf, String email) {
        this.navn = navn;
        this.tlf = tlf;
        this.email = email;
    }

    public Kunde() {}

    public String getNavn() {
        return navn;
    }
    public String getTlf() {
        return tlf;
    }
    public String getEmail() {
        return email;
    }
    public void setNavn(String navn) {
        this.navn = navn;
    }
    public void setTlf(String tlf) {
        this.tlf = tlf;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
