package com.MOOC.OnlineLearningPlatfrom.Controller;

// --- NEW IMPORTS ---
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.MOOC.OnlineLearningPlatfrom.Entity.Department;
import com.MOOC.OnlineLearningPlatfrom.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    // --- NEW LOGGER DEFINITION ---
    private static final Logger log = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<Department> getAllDepartments() {
        // --- NEW LOG MESSAGE ---
        log.info("Request received for GET /api/departments");
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Long id) {
        // --- NEW LOG MESSAGE ---
        log.info("Request received for GET /api/departments/{}", id);
        return departmentService.getDepartmentById(id);
    }

    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        // --- NEW LOG MESSAGE ---
        log.info("Request received for POST /api/departments");
        return departmentService.createDepartment(department);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        // --- NEW LOG MESSAGE ---
        log.info("Request received for DELETE /api/departments/{}", id);
        departmentService.deleteDepartment(id);
    }
}