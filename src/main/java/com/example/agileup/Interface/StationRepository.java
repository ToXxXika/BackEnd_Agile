package com.example.agileup.Interface;

import com.example.agileup.Models.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface StationRepository extends JpaRepository<Station,String> {
    @Query("Select s from Station s where s.nomstation= ?1")
    Station findStationByNomstation(String nomstation);
}
