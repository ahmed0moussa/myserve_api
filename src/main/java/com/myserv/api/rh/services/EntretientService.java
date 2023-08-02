package com.myserv.api.rh.services;


import com.myserv.api.rh.model.Entretien;
import com.myserv.api.rh.model.FeedBack;
import com.myserv.api.rh.model.Specialite;
import com.myserv.api.rh.model.User;
import com.myserv.api.rh.repository.EntretienRepository;
import com.myserv.api.rh.repository.FeedBackRepository;
import com.myserv.api.rh.repository.SpecialiteRepository;
import com.myserv.api.rh.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class EntretientService {

    private EntretienRepository entretienRepository;
    private UserRepository userRepository;
    private FeedBackRepository feedBackRepository;

    private SpecialiteRepository specialiteRepository ;

    private FileService fileService;

    public EntretientService(EntretienRepository entretienRepository,
                             UserRepository userRepository,
                             FeedBackRepository feedBackRepository,
                             SpecialiteRepository specialiteRepository,
                             FileService fileService) {
        this.entretienRepository = entretienRepository;
        this.userRepository = userRepository;
        this.feedBackRepository = feedBackRepository;
        this.specialiteRepository = specialiteRepository;
        this.fileService = fileService;
    }

    public List<FeedBack> getAllFeedbackOptions() {
        return feedBackRepository.findAll();
    }

    public Entretien createEntretien(Entretien entretien, String email, String feedbackId, String specialiteId)  throws IOException {

       /* if (file != null && !file.isEmpty()) {
            String loadFileId = fileService.addFile(file);
            entretien.setLoadFileId(loadFileId);
        }*/
        //String loadFileId = fileService.addFile(file);
        User user = userRepository.findByEmail(email).orElseThrow();
        FeedBack feedBack = feedBackRepository.findById(feedbackId).orElseThrow();
        Specialite specialite1 = specialiteRepository.findById(specialiteId).orElseThrow();
        entretien.setFeedback(feedBack);
        entretien.setRecruteur(user);
        entretien.setSpecialite(specialite1);
        //entretien.setLoadFileId(loadFileId);
        return entretienRepository.save(entretien);

    }

    private String saveFile(MultipartFile file) throws IOException {
        // Implement your file saving logic here and return the generated loadFileId
        // For example, you can use a file storage service like AWS S3 or save the file locally
        // Return the generated loadFileId
        return "your_generated_load_file_id";
    }

    public Optional<Entretien> getEntretienById(String id) {

        return entretienRepository.findById(id);
    }
}
