package pl.coderslab.cocktailMixer.service;

import org.springframework.stereotype.Service;
import pl.coderslab.cocktailMixer.model.User;

@Service
public interface UserService {

    User findByUserName(String name);
    void saveUser(User user);
}
