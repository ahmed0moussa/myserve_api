package com.myserv.api.rh.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document()
public class Infocandidate {
    @Id
    private String id ;

    @Indexed(name = "entretien")
    private Entretien entretien;

    @Indexed(name = "Phone")
    private String Phone;

    @Indexed(name = "Address")
    private String Address;

    @Indexed(name = "Email")
    private String Email;

    @Indexed(name = "Permit")
    private String Permit;

    @Indexed(name = "Age")
    private Number Age;

    @Indexed(name = "Status")
    private String Status;

    @Indexed(name = "Diploma")
    private String Diploma ;

    @Indexed(name = "YearsOfExperience")
    private Number YearsOfExperience;

    @Indexed(name = "Salary")
    private String Salary;

    @Indexed(name = "Preavis")
    private String Preavis;

    @Indexed(name = "VISA")
    private String VISA;

    @Indexed(name = "Mobilite")
    private String Mobilite;

    @Indexed(name = "AutredsBoites")
    private String AutredsBoites;

    @Indexed(name = "photoCandidate")
    private String photoCandidate;



}
