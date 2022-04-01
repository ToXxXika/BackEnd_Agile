package com.example.agileup.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Vague {
    private int idvague;
    private Integer idvisite;
    private Integer periode;
    private String enqueteur;
    private String station;
    private Collection<Operation> operationsByIdvague;
    private Visite visiteByIdvisite;
    private Personne personneByEnqueteur;
    private Station stationByStation;

    @Id
    @Column(name = "idvague")
    public int getIdvague() {
        return idvague;
    }

    public void setIdvague(int idvague) {
        this.idvague = idvague;
    }

    @Basic
    @Column(name = "idvisite")
    public Integer getIdvisite() {
        return idvisite;
    }

    public void setIdvisite(Integer idvisite) {
        this.idvisite = idvisite;
    }

    @Basic
    @Column(name = "periode")
    public Integer getPeriode() {
        return periode;
    }

    public void setPeriode(Integer periode) {
        this.periode = periode;
    }

    @Basic
    @Column(name = "enqueteur")
    public String getEnqueteur() {
        return enqueteur;
    }

    public void setEnqueteur(String enqueteur) {
        this.enqueteur = enqueteur;
    }

    @Basic
    @Column(name = "station")
    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vague vague = (Vague) o;
        return idvague == vague.idvague && Objects.equals(idvisite, vague.idvisite) && Objects.equals(periode, vague.periode) && Objects.equals(enqueteur, vague.enqueteur) && Objects.equals(station, vague.station);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idvague, idvisite, periode, enqueteur, station);
    }

    @OneToMany(mappedBy = "vagueByIdvague")
    public Collection<Operation> getOperationsByIdvague() {
        return operationsByIdvague;
    }

    public void setOperationsByIdvague(Collection<Operation> operationsByIdvague) {
        this.operationsByIdvague = operationsByIdvague;
    }

    @ManyToOne
    @JoinColumn(name = "idvisite", referencedColumnName = "idvisite",insertable = false,updatable = false)
    public Visite getVisiteByIdvisite() {
        return visiteByIdvisite;
    }

    public void setVisiteByIdvisite(Visite visiteByIdvisite) {
        this.visiteByIdvisite = visiteByIdvisite;
    }

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "enqueteur", referencedColumnName = "matricule",insertable = false,updatable = false)
    public Personne getPersonneByEnqueteur() {
        return personneByEnqueteur;
    }

    public void setPersonneByEnqueteur(Personne personneByEnqueteur) {
        this.personneByEnqueteur = personneByEnqueteur;
    }

    @ManyToOne
    @JoinColumn(name = "station", referencedColumnName = "nomstation",insertable = false,updatable = false)
    public Station getStationByStation() {
        return stationByStation;
    }

    public void setStationByStation(Station stationByStation) {
        this.stationByStation = stationByStation;
    }
}
