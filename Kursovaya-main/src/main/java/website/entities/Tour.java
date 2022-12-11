package website.entities;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "tours")
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tour implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private int price;

    @JoinColumn(name = "fk_finalposition")
    @OneToOne(cascade = CascadeType.ALL)
    private FinalPosition fk_finalposition;

    public Tour(String name, String description, int price, FinalPosition fk_finalposition) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.fk_finalposition = fk_finalposition;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", fk_finalposition=" + fk_finalposition +
                '}';
    }
}
