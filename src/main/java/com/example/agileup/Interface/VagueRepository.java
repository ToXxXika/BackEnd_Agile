package com.example.agileup.Interface;

import com.example.agileup.Models.Vague;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VagueRepository extends JpaRepository<Vague,Integer> {
}
