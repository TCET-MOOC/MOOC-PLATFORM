package com.MOOC.OnlineLearningPlatfrom.Controller;

// --- NEW IMPORTS ---
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.MOOC.OnlineLearningPlatfrom.Entity.UserAccount;
import com.MOOC.OnlineLearningPlatfrom.Service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    // --- NEW LOGGER DEFINITION ---
    private static final Logger log = LoggerFactory.getLogger(UserAccountController.class);

    @Autowired
    private UserAccountService userAccountService;

    @GetMapping
    public List<UserAccount> getAllUsers() {
        // --- NEW LOG MESSAGE ---
        log.info("Request received for GET /api/users");
        return userAccountService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserAccount getUserById(@PathVariable Long id) {
        // --- NEW LOG MESSAGE ---
        log.info("Request received for GET /api/users/{}", id);
        return userAccountService.getUserById(id);
    }

    @PostMapping
    public UserAccount createUser(@RequestBody UserAccount user) {
        // --- NEW LOG MESSAGE ---
        log.info("Request received for POST /api/users");
        return userAccountService.createUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        // --- NEW LOG MESSAGE ---
        log.info("Request received for DELETE /api/users/{}", id);
        userAccountService.deleteUser(id);
    }
}