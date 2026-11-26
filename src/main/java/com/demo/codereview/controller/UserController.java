package com.demo.codereview.controller;

import com.demo.codereview.model.User;
import com.demo.codereview.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserRepository userRepository;
    private final String apiSecret;

    public UserController(
            UserRepository userRepository,
            @Value("${app.api.secret:}") String apiSecret
    ) {
        this.userRepository = userRepository;
        this.apiSecret = apiSecret;
    }

/*    @GetMapping("/search")
    public List<User> searchUsers(@RequestParam String email) {
        // Appelle volontairement la méthode vulnérable exposée par UserRepository pour la démo
        List<User> users = userRepository.searchByEmailVulnerable(email);

        if (!users.isEmpty() && users.get(0).getEmail() != null
                && users.get(0).getEmail().equalsIgnoreCase(email)) {
            log.info("Found user: {}", users.get(0).getEmail());
        }

        return users;
    }

 /*   @GetMapping("/search-safe")
    public List<User> searchUsersSafe(@RequestParam String email) {
        return userRepository.findByEmailIgnoreCase(email);
    }
*/

    @GetMapping("/alls")
    public List<User> getAllUserss() {
        return userRepository.findAll();
    }


    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }




}
