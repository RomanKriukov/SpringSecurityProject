package org.kriukov.springsecuritydemo.rest;

import org.kriukov.springsecuritydemo.model.Developer;
import org.kriukov.springsecuritydemo.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/developers")
public class DeveloperRestController {

    @Autowired
    private DeveloperService developerService;

    @GetMapping
    public ResponseEntity<List<Developer>> getAll(){
        return ResponseEntity.ok(developerService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Developer> getById(@PathVariable Long id){
        return ResponseEntity.ok(developerService.getById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Developer> createDeveloper(@RequestBody Developer developer){
        return ResponseEntity.ok(developerService.createDeveloper(developer));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        developerService.deleteById(id);
    }
}
