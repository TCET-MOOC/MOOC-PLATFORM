package com.MOOC.OnlineLearningPlatfrom.Controller;

// --- NEW IMPORTS ---
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.MOOC.OnlineLearningPlatfrom.Entity.UserRole;
import com.MOOC.OnlineLearningPlatfrom.Service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-roles")
public class UserRoleController {

    // --- NEW LOGGER DEFINITION ---
    private static final Logger log = LoggerFactory.getLogger(UserRoleController.class);

    @Autowired
    private UserRoleService userRoleService;

    @GetMapping
    public List<UserRole> getAllUserRoles() {
        // --- NEW LOG MESSAGE ---
        log.info("Request received for GET /api/user-roles");
        return userRoleService.getAllUserRoles();
    }

    @GetMapping("/{id}")
    public UserRole getUserRoleById(@PathVariable Long id) {
        // --- NEW LOG MESSAGE ---
        log.info("Request received for GET /api/user-roles/{}", id);
        return userRoleService.getUserRoleById(id);
    }

    @PostMapping
    public UserRole createUserRole(@RequestBody UserRole userRole) {
        // --- NEW LOG MESSAGE ---
        log.info("Request received for POST /api/user-roles");
        return userRoleService.createUserRole(userRole);
    }

    @DeleteMapping("/{id}")
    public void deleteUserRole(@PathVariable Long id) {
        // --- NEW LOG MESSAGE ---
        log.info("Request received for DELETE /api/user-roles/{}", id);
        userRoleService.deleteUserRole(id);
    }
}