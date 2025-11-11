package com.semesterRegistrering.semesterRegistrering;

import jakarta.persistence.*;

@Entity
@Table(schema = "emne_registrering")
public class Emne {
    @Id
    private String kode;
    private String navn;
    private Integer studiepoeng;
    private String semester;
    private String type;
    private Integer antall;

    public Emne(){

    }
    public Emne(String kode, String navn, Integer studiepoeng, String semester, String type, Integer antall) {
        this.kode = kode;
        this.navn = navn;
        this.studiepoeng = studiepoeng;
        this.semester = semester;
        this.type = type;
        this.antall = antall;
    }

    public String getKode() {
        return kode;
    }
    public void setKode(String kode) {
        this.kode = kode;
    }
    public String getNavn() {
        return navn;
    }
    public void setNavn(String navn) {
        this.navn = navn;
    }
    public Integer getStudiepoeng() {
        return studiepoeng;
    }
    public void setStudiepoeng(Integer studiepoeng) {
        this.studiepoeng = studiepoeng;
    }
    public String getSemester() {
        return semester;
    }
    public void setSemester(String semester) {
        this.semester = semester;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Integer getAntall() {
        return antall;
    }
    public void setAntall(Integer antall) {
        this.antall = antall;
    }

    public void registrerInteresse() { antall++; }
}