package com.ansatteSystem.ansatteSystem.model;

import jakarta.persistence.*;

@Entity
public class Ansatt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fornavn;
    private String etternavn;
    private String stilling;
    private Integer mndlonn;

    public Ansatt() {}

    public Ansatt(String fornavn, String etternavn, String stilling, Integer mndlonn) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.stilling = stilling;
        this.mndlonn = mndlonn;
    }

    public Integer getId() { return id; }
    public String getFornavn() { return fornavn; }
    public void setFornavn(String fornavn) { this.fornavn = fornavn; }
    public String getEtternavn() { return etternavn; }
    public void setEtternavn(String etternavn) { this.etternavn = etternavn; }
    public String getStilling() { return stilling; }
    public void setStilling(String stilling) { this.stilling = stilling; }
    public Integer getMndlonn() { return mndlonn; }
    public void setMndlonn(Integer mndlonn) { this.mndlonn = mndlonn; }
}