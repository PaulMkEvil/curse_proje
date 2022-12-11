package website.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import website.entities.History;

import java.util.List;

public interface HistoryRepo extends JpaRepository<History, Integer> {
    History findHistoryByClientId(int client_id);
    List<History> findHistoriesByClientId(int client_id);
}
