package com.example.agileup.Controller;

import com.example.agileup.Interface.StationRepository;
import com.example.agileup.Models.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/station")
public class StationController {

    @Autowired
    StationRepository SR ;

    @PostMapping("/AjoutStation")
    public boolean AjouterStation(@RequestBody Station S){
        try {
            SR.save(S);
            return true ;
        }catch (Exception E){
            E.getMessage();
            return  false ;
        }
    }
    @GetMapping("/findStationByNom")
    public Station findStation(@RequestParam(name = "nomS") String nomS){
         try{
             System.out.println("Station Trouvée");
             return SR.findStationByNomstation(nomS);
         }catch (Exception E){
             System.out.println(E.getMessage());
             return null ;
         }
    }

}
