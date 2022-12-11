package website.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import website.entities.FinalPosition;

public interface PositionRepo extends JpaRepository<FinalPosition, Integer> {
    FinalPosition findFinalPositionById(int id);
}
