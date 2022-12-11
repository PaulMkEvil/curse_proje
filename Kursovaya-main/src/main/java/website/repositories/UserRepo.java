package website.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import website.entities.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
