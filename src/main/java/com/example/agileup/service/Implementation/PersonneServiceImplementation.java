package com.example.agileup.service.Implementation;

import com.example.agileup.Interface.PersonneRepository;
import com.example.agileup.Models.Personne;
import com.example.agileup.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonneServiceImplementation implements PersonneService {
    @Autowired
    PersonneRepository PR ;
    @Override
    public Personne findByMail(String mail) {
        if(null== PR.findPersonneByMail(mail)){
            System.out.println("******** Personne not Found **********");
        }else {
            System.out.println("******* Success"+PR.findPersonneByMail(mail).getNom()+" "+ PR.findPersonneByMail(mail).getPrenom());
        }
        return PR.findPersonneByMail(mail);
    }
}
