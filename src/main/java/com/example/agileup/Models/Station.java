package com.example.agileup.Models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Station {
    private String nomstation;
    private String gouvernorat;
    private String zone;
    private String gerance;
    private Integer longtitude;
    private Integer altitude;
    private Collection<Vague> vaguesByNomstation;

    @Id
    @Column(name = "nomstation")
    public String getNomstation() {
        return nomstation;
    }

    public void setNomstation(String nomstation) {
        this.nomstation = nomstation;
    }

    @Basic
    @Column(name = "gouvernorat")
    public String getGouvernorat() {
        return gouvernorat;
    }

    public void setGouvernorat(String gouvernorat) {
        this.gouvernorat = gouvernorat;
    }

    @Basic
    @Column(name = "zone")
    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    @Basic
    @Column(name = "gerance")
    public String getGerance() {
        return gerance;
    }

    public void setGerance(String gerance) {
        this.gerance = gerance;
    }

    @Basic
    @Column(name = "longtitude")
    public Integer getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(Integer longtitude) {
        this.longtitude = longtitude;
    }

    @Basic
    @Column(name = "altitude")
    public Integer getAltitude() {
        return altitude;
    }

    public void setAltitude(Integer altitude) {
        this.altitude = altitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return Objects.equals(nomstation, station.nomstation) && Objects.equals(gouvernorat, station.gouvernorat) && Objects.equals(zone, station.zone) && Objects.equals(gerance, station.gerance) && Objects.equals(longtitude, station.longtitude) && Objects.equals(altitude, station.altitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomstation, gouvernorat, zone, gerance, longtitude, altitude);
    }

    @OneToMany(mappedBy = "stationByStation")
    public Collection<Vague> getVaguesByNomstation() {
        return vaguesByNomstation;
    }

    public void setVaguesByNomstation(Collection<Vague> vaguesByNomstation) {
        this.vaguesByNomstation = vaguesByNomstation;
    }
}
