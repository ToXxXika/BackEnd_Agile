package com.example.agileup.Models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Visite {
    private int idvisite;
    private Date datevisite;
    private String locVisite;
    private Collection<Feedback> feedbacksByIdvisite;
    private Collection<Vague> vaguesByIdvisite;

    @Id
    @Column(name = "idvisite")
    public int getIdvisite() {
        return idvisite;
    }

    public void setIdvisite(int idvisite) {
        this.idvisite = idvisite;
    }

    @Basic
    @Column(name = "datevisite")
    public Date getDatevisite() {
        return datevisite;
    }

    public void setDatevisite(Date datevisite) {
        this.datevisite = datevisite;
    }

    @Basic
    @Column(name = "locVisite")
    public String getLocVisite() {
        return locVisite;
    }

    public void setLocVisite(String locVisite) {
        this.locVisite = locVisite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visite visite = (Visite) o;
        return idvisite == visite.idvisite && Objects.equals(datevisite, visite.datevisite) && Objects.equals(locVisite, visite.locVisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idvisite, datevisite, locVisite);
    }

    @OneToMany(mappedBy = "visiteByIdvisite")
    public Collection<Feedback> getFeedbacksByIdvisite() {
        return feedbacksByIdvisite;
    }

    public void setFeedbacksByIdvisite(Collection<Feedback> feedbacksByIdvisite) {
        this.feedbacksByIdvisite = feedbacksByIdvisite;
    }

    @OneToMany(mappedBy = "visiteByIdvisite")
    public Collection<Vague> getVaguesByIdvisite() {
        return vaguesByIdvisite;
    }

    public void setVaguesByIdvisite(Collection<Vague> vaguesByIdvisite) {
        this.vaguesByIdvisite = vaguesByIdvisite;
    }
}
