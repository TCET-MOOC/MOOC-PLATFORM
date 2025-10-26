package com.MOOC.OnlineLearningPlatfrom.Controller;

import com.MOOC.OnlineLearningPlatfrom.Entity.Module;
import com.MOOC.OnlineLearningPlatfrom.Repository.ModuleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modules") // Base API path for modules
public class ModuleController {

    private final ModuleRepository moduleRepo; // Repository for DB operations

    // Constructor injection for repository
    public ModuleController(ModuleRepository moduleRepo) {
        this.moduleRepo = moduleRepo;
    }

    @GetMapping // GET -> fetch all modules
    public List<Module> getAllModules() {
        return moduleRepo.findAll(); // return all modules from DB
    }

    @PostMapping // POST -> create new module
    public Module createModule(@RequestBody Module module) {
        return moduleRepo.save(module); // save new module in DB
    }

    @PutMapping("/{id}") // PUT -> update module by ID
    public ResponseEntity<Module> updateModule(@PathVariable Long id, @RequestBody Module moduleDetails) {
        return moduleRepo.findById(id).map(module -> {
            module.setTitle(moduleDetails.getTitle());   // update module title
            module.setPosition(moduleDetails.getPosition()); // update order/position
            return ResponseEntity.ok(moduleRepo.save(module)); // save and return updated module
        }).orElse(ResponseEntity.notFound().build()); // return 404 if not found
    }
}
