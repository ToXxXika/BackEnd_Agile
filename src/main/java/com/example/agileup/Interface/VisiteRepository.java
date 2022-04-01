package com.example.agileup.Interface;

import com.example.agileup.Models.Visite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisiteRepository extends JpaRepository<Visite,Integer> {
}
