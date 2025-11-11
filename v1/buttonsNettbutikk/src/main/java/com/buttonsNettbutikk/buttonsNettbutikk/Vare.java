package com.buttonsNettbutikk.buttonsNettbutikk;


import jakarta.persistence.*;

@Entity
@Table(name = "vare", schema = "butikk_vare")
public class Vare {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String navn;

    private Integer pris;

    private String beskrivelse;

    public Vare() {}

    public Vare(Integer id, String navn, Integer pris, String beskrivelse) {
        this.id = id;
        this.navn = navn;
        this.pris = pris;
        this.beskrivelse = beskrivelse;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNavn() {
        return navn;
    }
    public void setNavn(String navn) {
        this.navn = navn;
    }
    public Integer getPris() {
        return pris;
    }
    public void setPris(Integer pris) {
        this.pris = pris;
    }
    public String getBeskrivelse() {
        return beskrivelse;
    }
    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }
    public String toString() {
        return "[id=" + id + ", navn=" + navn + ", pris=" + pris + ", beskrivelse=" + beskrivelse + "]";
    }
}
