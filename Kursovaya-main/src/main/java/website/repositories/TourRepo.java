package website.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import website.entities.Tour;

import java.util.List;

public interface TourRepo extends JpaRepository<Tour, Integer> {
    Tour findTourById(int id);
//    List<Tour> findToursBy;

}
