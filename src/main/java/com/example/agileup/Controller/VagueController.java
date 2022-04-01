package com.example.agileup.Controller;

import com.example.agileup.Interface.VagueRepository;
import com.example.agileup.Models.Vague;
import com.example.agileup.Models.Visite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping("/vague")
@RestController
public class VagueController {
    @Autowired
    VagueRepository VR ;
    @Autowired
    PersonneController Pc ;
    @Autowired
    StationController Sc ;


    @PostMapping("/ajoutervag")
    public boolean ajoutervag(@RequestBody List<Vague> ListV){
        try {
            for(int i=0;i<ListV.size();i++){
                if((Pc.ChercherPersonne(ListV.get(i).getEnqueteur())!= null) && (Sc.findStation(ListV.get(i).getStation())!= null))
                {
                    //TODO : the only thing we need to remember a visit must be created first while
                    // creating this instance of Vague
                    VR.save(ListV.get(i));
                }
            }

            return  true;

        }catch (Exception E){
            System.out.println(E.getMessage());
            return false;
        }
    }
}
