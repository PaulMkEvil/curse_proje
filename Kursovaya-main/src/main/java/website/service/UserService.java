package website.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import website.entities.User;
import website.entities.enums.Role;
import website.repositories.UserRepo;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public boolean createUser(User user) {
        String username = user.getUsername();
        if (userRepo.findByUsername(username) != null) return false;
        user.setActive(true);
        user.getRoles().add(Role.ROLE_USER);
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        log.info("Saving new User with username: {}", username);
        userRepo.save(user);
        return true;
    }
}
