package com.avdelingCRUDRepo.avdelingCRUDRepo;


import jakarta.persistence.*;

@Entity
@Table(name = "ansatt", schema = "ansatt_avdeling")
public class Ansatt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    @Column(nullable = false, length = 30)
    private String navn;

    @Column(nullable = false)
    private char kjonn;

    @Column(nullable = false)
    private int manedslonn;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "avdeling_id", nullable = false)
    private Avdeling avdeling;

    public Ansatt() {}

    public Ansatt(String navn, char kjonn, int manedslonn, Avdeling avdeling) {
        this.navn = navn;
        this.kjonn = kjonn;
        this.manedslonn = manedslonn;
        this.avdeling = avdeling;
    }

    // ---- Gettere og settere ----
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public char getKjonn() {
        return kjonn;
    }

    public void setKjonn(char kjonn) {
        this.kjonn = kjonn;
    }

    public int getManedslonn() {
        return manedslonn;
    }

    public void setManedslonn(int manedslonn) {
        this.manedslonn = manedslonn;
    }

    public Avdeling getAvdeling() {
        return avdeling;
    }

    public void setAvdeling(Avdeling avdeling) {
        this.avdeling = avdeling;
    }

    @Override
    public String toString() {
        return "Ansatt{" +
                "id=" + id +
                ", navn='" + navn + '\'' +
                ", kjonn=" + kjonn +
                ", manedslonn=" + manedslonn +
                ", avdeling=" + (avdeling != null ? avdeling.getNavn() : "null") +
                '}';
    }
}
