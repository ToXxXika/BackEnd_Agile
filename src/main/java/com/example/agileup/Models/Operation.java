package com.example.agileup.Models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Operation {
    private int idop;
    private Date dateop;
    private Integer idvague;
    private String depop;
    private Vague vagueByIdvague;

    @Id
    @Column(name = "idop")
    public int getIdop() {
        return idop;
    }

    public void setIdop(int idop) {
        this.idop = idop;
    }

    @Basic
    @Column(name = "dateop")
    public Date getDateop() {
        return dateop;
    }

    public void setDateop(Date dateop) {
        this.dateop = dateop;
    }

    @Basic
    @Column(name = "idvague")
    public Integer getIdvague() {
        return idvague;
    }

    public void setIdvague(Integer idvague) {
        this.idvague = idvague;
    }

    @Basic
    @Column(name = "depop")
    public String getDepop() {
        return depop;
    }

    public void setDepop(String depop) {
        this.depop = depop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return idop == operation.idop && Objects.equals(dateop, operation.dateop) && Objects.equals(idvague, operation.idvague) && Objects.equals(depop, operation.depop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idop, dateop, idvague, depop);
    }

    @ManyToOne
    @JoinColumn(name = "idvague", referencedColumnName = "idvague",insertable = false,updatable = false)
    public Vague getVagueByIdvague() {
        return vagueByIdvague;
    }

    public void setVagueByIdvague(Vague vagueByIdvague) {
        this.vagueByIdvague = vagueByIdvague;
    }
}
