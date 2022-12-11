package website.entities;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import website.repositories.ClientRepo;
import website.repositories.HistoryRepo;
import website.repositories.TourRepo;
import website.repositories.UserRepo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClientTest {

    @Autowired
    private ClientRepo clientRepo;
    @Autowired
    private TourRepo tourRepo;

    @Autowired
    private HistoryRepo historyRepo;

    @Autowired
    private UserRepo userRepo;

    @Test
    void addClient(){
        Client client = new Client("Pavel", "Makeev", 19, "7-977-605-54 50");
        clientRepo.saveAndFlush(client);
    }

    @Test
    void addUser(){
        User user = new User("Pavel", "123123", true);
        userRepo.saveAndFlush(user);
    }

    @Test
    void addTour(){
        Tour tour0 = new Tour("China tour", "Wonderful tour around china", 50000, new FinalPosition("China", "Beijing", "Mao Hotel"));
        Tour tour1 = new Tour("Italian tour", "The best places in Italy", 150000, new FinalPosition("Italy", "Venice", "Venice Hotel"));
        Tour tour2 = new Tour("Summer tour", "Best beaches in Turkey", 75000, new FinalPosition("Turkey", "Istanbul", "Mehmed Hotel"));
        tourRepo.saveAllAndFlush(Arrays.asList(tour0, tour1, tour2));
    }

    @Test
    void addHistory(){
        Client client = new Client("Ilya", "Lenev", 20, "7 916 545 2546");
        clientRepo.saveAndFlush(client);
        Tour tour = new Tour("Crazy tour", "Tour for your family", 66666, new FinalPosition("Africa", "Kahir", "Kahir's Hotel"));
        tourRepo.saveAndFlush(tour);
        History history = new History(client.getId(), tour.getId());
        historyRepo.saveAndFlush(history);
    }

    @Test
    void GetHistoryByClient(){
        Client client = clientRepo.findClientByFirstnameAndLastnameAndYearsAndTelNumber("Mihail", "Zubkov", 19, "89776055450");
        System.out.println(historyRepo.findHistoryByClientId(client.getId()));
    }

    @Test
    void getClientById(){
        System.out.println(clientRepo.findClientById(1));
    }

    @Test
    void getAllClient(){
        System.out.println(clientRepo.findAll());
    }

    @Test
    void getAllTours(){
        System.out.println(tourRepo.findAll());
    }



}