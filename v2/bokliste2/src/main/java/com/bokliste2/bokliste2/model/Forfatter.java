package com.bokliste2.bokliste2.model;


import jakarta.persistence.*;
import com.bokliste2.bokliste2.model.Bok;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "forfatter", schema = "bok_visning")
public class Forfatter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "author_fname")
    private String authorFName;

    @Column(name = "author_lname")
    private String authorLName;

    @ManyToMany(mappedBy = "authors", fetch = FetchType.LAZY)
    private Set<Bok> books = new HashSet<>();

    public Forfatter() {}

    public Forfatter(String authorFName, String authorLName) {
        this.authorFName = authorFName;
        this.authorLName = authorLName;
    }

    // Gettere/settere
    public int getId() { return id; }
    public String getAuthorFName() { return authorFName; }
    public void setAuthorFName(String authorFName) { this.authorFName = authorFName; }
    public String getAuthorLName() { return authorLName; }
    public void setAuthorLName(String authorLName) { this.authorLName = authorLName; }
    public Set<Bok> getBooks() { return books; }
    public void setBooks(Set<Bok> books) { this.books = books; }
    @Override
    public String toString() {
        return authorFName + " " + authorLName;
    }
}
