package com.myserv.api.rh.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.MultipartFile;

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

    @JsonFormat(pattern="dd/MM/yyyy")
    @Indexed(name = "datecreation")
    private Date datecreation ;

    @JsonFormat(pattern="yyyy-MM-dd")
    @LastModifiedDate
    @Indexed(name = "datemodif")
    private Date  datemodif ;


    @Indexed(name = "feedback")
    private FeedBack feedback ;

    @Indexed(name = "specialite")
    private Specialite specialite ;

    @Indexed(name = "commentaire")
    private String commentaire ;

    @Indexed(name = "recruteur")
    private String recruteur ;


    @Indexed(name = "loadfileid")
    private String loadFileId ; ;





}
