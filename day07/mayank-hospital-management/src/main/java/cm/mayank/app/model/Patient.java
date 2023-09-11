package cm.mayank.app.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@Component
public class Patient {

    private String patient;
    private String id;
    private String hospital;
    private String disease;

    public Patient(String patient, String id, String hospital, String disease){

        this.patient = patient;
        this.id = id;
        this.hospital = hospital;
        this.disease = disease;

    }
}
