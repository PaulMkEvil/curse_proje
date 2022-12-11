package website.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import website.entities.Client;
import website.entities.History;
import website.entities.Tour;
import website.repositories.ClientRepo;
import website.repositories.HistoryRepo;
import website.repositories.TourRepo;

import java.util.*;

@Controller
public class MainController {

    @Autowired
    private ClientRepo clientRepo;
    @Autowired
    private TourRepo tourRepo;
    @Autowired
    private HistoryRepo historyRepo;

    @GetMapping("home")
    public String homeGet(Model model) {
        model.addAttribute("title", "Главная страница");
        List<Tour> tours = tourRepo.findAll();
        model.addAttribute("tours", tours);
        return "home";
    }

    @PostMapping("home")
    public String homePost(@RequestParam HashMap<String, String> map, Model model) {
        System.out.println(map);
        int tour_id = Integer.parseInt(map.get("tour_id"));
        if (map.get("firstname") != null && map.get("lastname") != null && map.get("years") != null && map.get("tel_number") != null) {
            model.addAttribute("title", "Главная страница");
            String firstname = map.get("firstname");
            String lastname = map.get("lastname");
            int years = Integer.parseInt(map.get("years"));
            String tel_number = Client.EditPhoneNumber(map.get("tel_number"));
            Client client = clientRepo.findClientByFirstnameAndLastnameAndYearsAndTelNumber(firstname, lastname, years, tel_number);
            if (client == null) {
                client = new Client(firstname, lastname, years, tel_number);
                clientRepo.saveAndFlush(client);
            }
            historyRepo.saveAndFlush(new History(client.getId(), tour_id));
            System.out.println(client);
            return "redirect:/home";
        }
        return "redirect:/buy?tour_id=" + tour_id;
    }


    @GetMapping("home/{id}")
    public String homeIdGet(@PathVariable(name = "id") int id, Model model) {
        Tour tour = tourRepo.findTourById(id);
        model.addAttribute("tour", tour);
        return "homeid";
    }

    //По факту не надо
    @PostMapping("home/{id}")
    public String homeIdPost(@RequestParam HashMap<String, Object> map, @PathVariable(name = "id") int id, Model model) {
        Tour tour = tourRepo.findTourById(id);
        System.out.println(map);
        model.addAttribute("tour", tour);
        return "redirect:/buy";
    }

    @GetMapping("buy")
    public String buyGet(@RequestParam(name = "tour_id", required = false) String tour_id, Model model){
        Tour tour = tourRepo.findTourById(Integer.parseInt(tour_id));
        model.addAttribute("tour", tour);
        return "buy";
    }

    @GetMapping("historytour")
    public String historytourGet(Model model){
        return "historytour";
    }

    @PostMapping("historytour")
    public String historytourPost(@RequestParam HashMap<String, String> map, Model model){
        System.out.println( map.get("lastname") + " " +  map.get("tel_number"));
        String lastname = map.get("lastname");
        String tel_number = Client.EditPhoneNumber(map.get("tel_number"));
        Client client = clientRepo.findClientByLastnameAndTelNumber(lastname, tel_number);
        if(client != null){
            List<History> histories = historyRepo.findHistoriesByClientId(client.getId());
            List<Tour> tours = new ArrayList<>();
            for (History history : histories)
            {
                tours.add(tourRepo.findTourById(history.getTourId()));
            }
            Collections.reverse(tours);
            model.addAttribute("tours", tours);
            return "historytour";
        }
        return "redirect:/historytour";
    }

    @PostMapping("buy")
    public String buyPost(@RequestParam HashMap<String, String> map, Model model){
        System.out.println(map);
        Tour tour = tourRepo.findTourById(Integer.parseInt(map.get("tour_id")));
        model.addAttribute("tour", tour);
        return "buy";
    }

    @GetMapping("about")
    public String about(){
        return "about";
    }

}