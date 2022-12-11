package website.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "history")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class History implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "fkclient")
    private int clientId;

    @Column(name = "fktour")
    private int tourId;

    public History(int client_id, int tour_id) {
        this.clientId = client_id;
        this.tourId = tour_id;
    }
}
