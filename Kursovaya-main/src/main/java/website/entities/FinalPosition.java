package website.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "finalposition")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FinalPosition implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "hotel")
    private String hotel;

    public FinalPosition(String country, String city, String hotel) {
        this.country = country;
        this.city = city;
        this.hotel = hotel;
    }
}
