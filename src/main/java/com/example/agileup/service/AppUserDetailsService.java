package com.example.agileup.service;

import com.example.agileup.Models.Personne;
import com.example.agileup.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    PersonneService Ps ;
    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        Personne p = Ps.findByMail(mail);
        System.out.println("************** LoadUserByUsername Success **************");
         return (UserDetails) p ;
    }
}
