package com.example.agileup.Controller;

import com.example.agileup.Interface.OperationRepository;
import com.example.agileup.Interface.PersonneRepository;
import com.example.agileup.Models.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/operation")
public class OperationController {

    @Autowired
    OperationRepository OR ;
    @PostMapping("AjouterOp")
    public boolean ajouterOperation(@RequestBody Operation operation){
      return false ;
    }
}
