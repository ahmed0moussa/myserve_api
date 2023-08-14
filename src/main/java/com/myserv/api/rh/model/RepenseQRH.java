package com.myserv.api.rh.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document()
public class RepenseQRH {
    @Id
    private String id ;

    @Indexed(name = "FrenchLevel")
    private String FrenchLevel;

    @Indexed(name = "Englishlevel")
    private String Englishlevel;

    @Indexed(name = "Qualities")
    private String Qualities;

    @Indexed(name = "Faults")
    private String Faults;

    @Indexed(name = "Q2")
    private String Q2;

    @Indexed(name = "Q3")
    private String Q3;

    @Indexed(name = "Q4")
    private String Q4;

    @Indexed(name = "Q5")
    private String Q5;

}
