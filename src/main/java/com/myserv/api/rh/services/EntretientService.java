package com.myserv.api.rh.services;


import com.myserv.api.rh.configifile.CvStorge;
import com.myserv.api.rh.model.Entretien;
import com.myserv.api.rh.model.FeedBack;
import com.myserv.api.rh.model.Specialite;
import com.myserv.api.rh.model.User;
import com.myserv.api.rh.repository.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.io.IOException;

import java.util.List;
import java.util.Optional;


@Service
public class EntretientService {

    @Autowired
    private EntretienRepository entretienRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FeedBackRepository feedBackRepository;

    @Autowired
    private SpecialiteRepository specialiteRepository ;

    @Autowired
    private CvStorge cvStorge;



    public List<FeedBack> getAllFeedbackOptions() {
        return feedBackRepository.findAll();
    }

    public Entretien createEntretien(Entretien entretien, String email, String specialiteId)  throws IOException {

        String DefaultFeedback = "64b1af43128f38495981525a";
        User user = userRepository.findByEmail(email).orElseThrow();
        Specialite specialite = specialiteRepository.findById(specialiteId).orElseThrow();
        FeedBack feedback = feedBackRepository.findById(DefaultFeedback).orElseThrow();
        entretien.setFeedback(feedback);
        entretien.setRecruteur(user);
        entretien.setSpecialite(specialite);

        return entretienRepository.save(entretien);

    }
    public Optional<Entretien> getEntretienById(String id) {

        return entretienRepository.findById(id);
    }

    public  String uploadFileCv(String entretienId, MultipartFile image) {
        Entretien entretien = this.getEntretienById(entretienId).orElseThrow();
        String fileName=cvStorge.store(image);
        //api de controller
        String fileDownloadUrl= ServletUriComponentsBuilder.fromCurrentContextPath().path("api/v1/downloadCvFile/").path(fileName).toUriString();


        if (entretien!=null)
            entretien.setFile(fileDownloadUrl);
        return fileDownloadUrl;
    }




}
