package com.example.agileup.Interface;

import com.example.agileup.Models.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonneRepository extends JpaRepository<Personne,Integer> {
    @Query("Select p from Personne p where p.mail = ?1")
    Personne findPersonneByMail(String mail);
    @Query("Select p from Personne p where p.matricule = ?1")
    Personne findPersonneByMatricule(String Matricule);
    @Query("Select p from Personne p where p.mail=?1 and p.motdepasse=?2")
    Personne login(String mail,String motdepasse);


}
