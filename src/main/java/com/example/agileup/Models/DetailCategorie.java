package com.example.agileup.Models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "detail_categorie", schema = "agileup", catalog = "")
public class DetailCategorie {
    private String idcat;
    private String question;
    private String reponse;
    private Integer scoreQ;
    private List<Categorie> categorieByIdcat;

    @Id
    @Column(name = "idcat")
    public String getIdcat() {
        return idcat;
    }

    public void setIdcat(String idcat) {
        this.idcat = idcat;
    }

    @Basic
    @Column(name = "question")
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Basic
    @Column(name = "reponse")
    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    @Basic
    @Column(name = "scoreQ")
    public Integer getScoreQ() {
        return scoreQ;
    }

    public void setScoreQ(Integer scoreQ) {
        this.scoreQ = scoreQ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetailCategorie that = (DetailCategorie) o;
        return Objects.equals(idcat, that.idcat) && Objects.equals(question, that.question) && Objects.equals(reponse, that.reponse) && Objects.equals(scoreQ, that.scoreQ);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcat, question, reponse, scoreQ);
    }

    @OneToMany(mappedBy = "detailCategorieByIdcat")
    public List<Categorie> getCategorieByIdcat() {
        return categorieByIdcat;
    }

    public void setCategorieByIdcat(List<Categorie> categorieByIdcat) {
        this.categorieByIdcat = categorieByIdcat;
    }
}
