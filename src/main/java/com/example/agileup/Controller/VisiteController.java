package com.example.agileup.Controller;

import com.example.agileup.Interface.VisiteRepository;
import com.example.agileup.Models.Visite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/visite")
public class VisiteController {

    @Autowired
    VisiteRepository VR ;

    @PostMapping("/AjoutVisite")
    public boolean AjoutVisite(@RequestBody Visite V){
        try {
          VR.save(V);
          return true ;
        }catch (Exception E ){
            System.out.println(E.getMessage());
            return false;
        }
    }
}
