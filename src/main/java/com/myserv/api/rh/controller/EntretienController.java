package com.myserv.api.rh.controller;


import com.myserv.api.rh.model.Entretien;
import com.myserv.api.rh.repository.EntretienRepository;
import com.myserv.api.rh.services.EntretientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class  EntretienController {

    @Autowired
    private EntretienRepository entretienRepository;

    private EntretientService entretientService;


    public EntretienController(EntretienRepository entretienRepository, EntretientService entretientService) {
        this.entretienRepository = entretienRepository;
        this.entretientService = entretientService;
    }

   @PostMapping(value = "/api/v1/entretien/create" )
    public String place(@RequestBody Entretien entretien, Principal principal,@RequestParam String feedbackId, @RequestParam String specialite) throws IOException {

        String username = principal.getName();
        entretientService.createEntretien(entretien, username, feedbackId, specialite);
        return "cava";
    }
    /*@PostMapping("/api/v1/entretien/create")
    public ResponseEntity<Entretien> createEntretien(
            @ModelAttribute Entretien entretien,
            Principal principal,
            @RequestParam String feedbackId,
            @RequestParam String specialite,
            @RequestParam(name = "file", required = false) MultipartFile file
    ) throws IOException {
        String username = principal.getName();
        Entretien savedEntretien = entretientService.createEntretien(entretien, username, feedbackId, specialite, file);
        return new ResponseEntity<>(savedEntretien, HttpStatus.CREATED);
    }*/
    @GetMapping("/api/v1/entretien/all")
    public List<Entretien> all(){
        return entretienRepository.findAll();

    }

    @GetMapping("/api/v1/entretien/specialite")
    public List<Entretien> getentretienBySpecialiteId(String specialiteId){
        return  entretienRepository.findBySpecialiteId(specialiteId);
    }

}
