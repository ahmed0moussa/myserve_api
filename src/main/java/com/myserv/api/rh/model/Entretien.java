package com.myserv.api.rh.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;


@Data
@Document()
public class Entretien {

    @Id
    private String id ;

    @Indexed(name = "nom")
    private String nom ;

    @Indexed(name = "prenom")
    private String prenom ;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Indexed(name = "datecreation")
    private Date datecreation ;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Indexed(name = "datemodif")
    private Date  datemodif ;

    @Indexed(name = "time")
    @JsonFormat(pattern = "HH:mm")
    private String time ;

    @DBRef
    @Indexed(name = "feedback")
    private FeedBack feedback ;

    @Indexed(name = "specialite")
    private Specialite specialite ;

    @Indexed(name = "commentaire")
    private String commentaire ;

    @Indexed(name = "recruteur")
    private User recruteur ;


    @Indexed(name = "loadfileid")
    private String loadFileId ; ;





}
