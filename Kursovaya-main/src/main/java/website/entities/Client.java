package website.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import website.repositories.HistoryRepo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "client")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "years")
    private int years;

    @Column(name = "tel_number")
    private String telNumber;

    public Client(String firstname, String lastname, int years, String telNumber)
    {
        this.firstname = firstname;
        this.lastname = lastname;
        this.years = years;
        this.telNumber = EditPhoneNumber(telNumber);
    }

    public static String EditPhoneNumber(String phone_number){
        if(phone_number.charAt(0) == '7')
            phone_number = "8" + phone_number.substring(1);
        return phone_number.replaceAll("-", "").replaceAll(" ", "").replaceAll("\\+", "");
    }

}
