package com.example.agileup.Models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Feedback {
    private Integer idvisite;
    private String idcat;
    private Integer score;
    private int idfeed;
    private Visite visiteByIdvisite;
    private Categorie categorieByIdcat;

    @Basic
    @Column(name = "idvisite")
    public Integer getIdvisite() {
        return idvisite;
    }

    public void setIdvisite(Integer idvisite) {
        this.idvisite = idvisite;
    }

    @Basic
    @Column(name = "idcat")
    public String getIdcat() {
        return idcat;
    }

    public void setIdcat(String idcat) {
        this.idcat = idcat;
    }

    @Basic
    @Column(name = "score")
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Id
    @Column(name = "idfeed")
    public int getIdfeed() {
        return idfeed;
    }

    public void setIdfeed(int idfeed) {
        this.idfeed = idfeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feedback feedback = (Feedback) o;
        return idfeed == feedback.idfeed && Objects.equals(idvisite, feedback.idvisite) && Objects.equals(idcat, feedback.idcat) && Objects.equals(score, feedback.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idvisite, idcat, score, idfeed);
    }

    @ManyToOne
    @JoinColumn(name = "idvisite", referencedColumnName = "idvisite",insertable = false,updatable = false)
    public Visite getVisiteByIdvisite() {
        return visiteByIdvisite;
    }

    public void setVisiteByIdvisite(Visite visiteByIdvisite) {
        this.visiteByIdvisite = visiteByIdvisite;
    }

    @ManyToOne
    @JoinColumn(name = "idcat", referencedColumnName = "idcat",insertable = false,updatable = false)
    public Categorie getCategorieByIdcat() {
        return categorieByIdcat;
    }

    public void setCategorieByIdcat(Categorie categorieByIdcat) {
        this.categorieByIdcat = categorieByIdcat;
    }
}
