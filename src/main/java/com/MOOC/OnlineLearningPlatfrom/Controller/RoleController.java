package com.MOOC.OnlineLearningPlatfrom.Controller;

// --- NEW IMPORTS ---
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.MOOC.OnlineLearningPlatfrom.Entity.Role;
import com.MOOC.OnlineLearningPlatfrom.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    // --- NEW LOGGER DEFINITION ---
    private static final Logger log = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<Role> getAllRoles() {
        // --- NEW LOG MESSAGE ---
        log.info("Request received for GET /api/roles");
        return roleService.getAllRoles();
    }

    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable Long id) {
        // --- NEW LOG MESSAGE ---
        log.info("Request received for GET /api/roles/{}", id);
        return roleService.getRoleById(id);
    }

    @PostMapping
    public Role createRole(@RequestBody Role role) {
        // --- NEW LOG MESSAGE ---
        log.info("Request received for POST /api/roles");
        return roleService.createRole(role);
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Long id) {
        // --- NEW LOG MESSAGE ---
        log.info("Request received for DELETE /api/roles/{}", id);
        roleService.deleteRole(id);
    }
}