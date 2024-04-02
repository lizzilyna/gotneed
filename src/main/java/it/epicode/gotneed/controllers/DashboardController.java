package it.epicode.gotneed.controllers;

import it.epicode.gotneed.security.JwtFilter;
import it.epicode.gotneed.security.JwtTools;
import it.epicode.gotneed.services.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {

     @Autowired
    private JwtTools jwtTools;
    @Autowired
    private JwtFilter jwtFilter;

    @GetMapping ("/dashboard")
    public ResponseEntity<String>getDashboard(){
        return ResponseEntity.ok("benvenuta");
    }
}
