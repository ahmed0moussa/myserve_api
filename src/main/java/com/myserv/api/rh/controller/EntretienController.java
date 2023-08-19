package com.myserv.api.rh.controller;


import com.myserv.api.rh.model.Entretien;
import com.myserv.api.rh.configifile.CvStorge;
import com.myserv.api.rh.services.EntretientService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class EntretienController {

   /* @Autowired
    private EntretienRepository entretienRepository;*/

    @Autowired
    private EntretientService entretientService;
    @Autowired
    private CvStorge cvStorage;





    @PostMapping(value = "/api/v1/entretien/create" )
    public Entretien place(@RequestBody Entretien entretien,

                        Principal principal,
                        @RequestParam String specialite) throws IOException {
        String username = principal.getName();

        entretientService.createEntretien(entretien, username, specialite);
        return entretien;
    }

    @PostMapping(value = "/test")
    public String test(@RequestBody Entretien entretien, @RequestParam String specialite) throws IOException {

        return "cava"+ specialite;
    }

    /*@GetMapping("/api/v1/entretien/all")
    public List<Entretien> all() {
        return entretienRepository.findAll();

    }

    @GetMapping("/api/v1/entretien/specialite")
    public List<Entretien> getentretienBySpecialiteId(String specialiteId) {
        return entretienRepository.findBySpecialiteId(specialiteId);
    }*/
    @PostMapping("/uploadImage/{id}")
    public String uploadImageFilms(@PathVariable String id, MultipartFile image) {
        return entretientService.uploadFileCv(id, image);
    }

    @GetMapping("/downloadFilmImage/{imageName}")
    public ResponseEntity<Resource> downloadFilmImage(@PathVariable String imageName, HttpServletRequest request) {
        return this.cvStorage.downloadCvFile(imageName, request);
    }
}
