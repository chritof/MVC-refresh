package com.bokliste2.bokliste2.model;


import jakarta.persistence.*;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "bok", schema = "bok_visning")
public class Bok {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    @Column(name = "year_of_release")
    private int yearOfRelease;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "bok_forfatter",
            schema = "bok_visning",
            joinColumns = @JoinColumn(name = "bok_id"),
            inverseJoinColumns = @JoinColumn(name = "forfatter_id")
    )
    private Set<Forfatter> authors = new HashSet<>();

    public Bok() {
    }

    public Bok(String title, int yearOfRelease) {
        this.title = title;
        this.yearOfRelease = yearOfRelease;
    }

    // Gettere/settere
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public Set<Forfatter> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Forfatter> authors) {
        this.authors = authors;
    }
}