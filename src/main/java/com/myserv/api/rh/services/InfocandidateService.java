package com.myserv.api.rh.services;

import com.myserv.api.rh.model.Entretien;
import com.myserv.api.rh.model.Infocandidate;
import com.myserv.api.rh.repository.EntretienRepository;
import com.myserv.api.rh.repository.InfocandidateRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InfocandidateService {

    private InfocandidateRepository infocandidateRepository;
    private EntretienRepository entretienRepository;

    public Infocandidate createInfocandidate(Infocandidate infocandidate, String entretienId){
         Entretien entretien= entretienRepository.findById(entretienId).orElseThrow();
         infocandidate.setEntretien(entretien);

        return infocandidateRepository.save(infocandidate);
    }
   public Infocandidate findByEntretienId(String entretienId){

        return null;
   }

}
