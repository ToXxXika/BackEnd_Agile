package com.example.agileup.Models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Categorie {
    private String idcat;
    private String titrecat;
    private Integer scoretotale;
    private DetailCategorie detailCategorieByIdcat;
    private Collection<Feedback> feedbacksByIdcat;

    @Id
    @Column(name = "idcat")
    public String getIdcat() {
        return idcat;
    }

    public void setIdcat(String idcat) {
        this.idcat = idcat;
    }

    @Basic
    @Column(name = "titrecat")
    public String getTitrecat() {
        return titrecat;
    }

    public void setTitrecat(String titrecat) {
        this.titrecat = titrecat;
    }

    @Basic
    @Column(name = "scoretotale")
    public Integer getScoretotale() {
        return scoretotale;
    }

    public void setScoretotale(Integer scoretotale) {
        this.scoretotale = scoretotale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categorie categorie = (Categorie) o;
        return Objects.equals(idcat, categorie.idcat) && Objects.equals(titrecat, categorie.titrecat) && Objects.equals(scoretotale, categorie.scoretotale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcat, titrecat, scoretotale);
    }

    @ManyToOne
    @JoinColumn(name = "idcat", referencedColumnName = "idcat", nullable = false,insertable = false,updatable = false)
    public DetailCategorie getDetailCategorieByIdcat() {
        return detailCategorieByIdcat;
    }

    public void setDetailCategorieByIdcat(DetailCategorie detailCategorieByIdcat) {
        this.detailCategorieByIdcat = detailCategorieByIdcat;
    }

    @OneToMany(mappedBy = "categorieByIdcat")
    public Collection<Feedback> getFeedbacksByIdcat() {
        return feedbacksByIdcat;
    }

    public void setFeedbacksByIdcat(Collection<Feedback> feedbacksByIdcat) {
        this.feedbacksByIdcat = feedbacksByIdcat;
    }
}
