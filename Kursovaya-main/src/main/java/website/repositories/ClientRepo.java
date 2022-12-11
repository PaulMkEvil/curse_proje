package website.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import website.entities.Client;

public interface ClientRepo extends JpaRepository<Client, Integer> {
    Client findClientById(int id);
    Client findClientByFirstnameAndLastnameAndYearsAndTelNumber(String firstname, String lastname, Integer years, String telNumber);
    Client findClientByLastnameAndTelNumber(String lastname, String telNumber);
}
