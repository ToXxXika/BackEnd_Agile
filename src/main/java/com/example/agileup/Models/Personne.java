package com.example.agileup.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
public class Personne implements UserDetails {
    private String nom;
    private String prenom;
    private String matricule;
    private Integer telephone;
    private String mail;
    private String role;
    private String motdepasse;
    private List<Vague> vaguesByMatricule;

    @Basic
    @Column(name = "nom")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "prenom")
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Id
    @Column(name = "matricule")
    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    @Basic
    @Column(name = "telephone")
    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    @Basic
    @Column(name = "mail")
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Basic
    @Column(name = "motdepasse")
    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personne personne = (Personne) o;
        return Objects.equals(nom, personne.nom) && Objects.equals(prenom, personne.prenom) && Objects.equals(matricule, personne.matricule) && Objects.equals(telephone, personne.telephone) && Objects.equals(mail, personne.mail) && Objects.equals(role, personne.role) && Objects.equals(motdepasse, personne.motdepasse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom, matricule, telephone, mail, role, motdepasse);
    }

    @JsonManagedReference
    @OneToMany(mappedBy = "personneByEnqueteur")
    public List<Vague> getVaguesByMatricule() {
        return vaguesByMatricule;
    }

    public void setVaguesByMatricule(List<Vague> vaguesByMatricule) {
        this.vaguesByMatricule = vaguesByMatricule;
    }

    @Transient
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Transient
    @Override
    public String getPassword() {
        return motdepasse;
    }

    @Transient
    @Override
    public String getUsername() {
        return mail;
    }

    @Transient
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Transient
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Transient
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Transient
    @Override
    public boolean isEnabled() {
        return true;
    }
}
