package cm.mayank.app.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@Component
public class Hospital {

    private String name;
    private String id;
    private String address;

    public Hospital(String name, String id, String address){

        this.name = name;
        this.id = id;
        this.address = address;

    }
}
