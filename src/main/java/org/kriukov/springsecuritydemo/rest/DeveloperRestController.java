package org.kriukov.springsecuritydemo.rest;

import org.kriukov.springsecuritydemo.model.Developer;
import org.kriukov.springsecuritydemo.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/developers")
public class DeveloperRestController {

    @Autowired
    private DeveloperService developerService;

    @GetMapping
    @PreAuthorize("hasAuthority('developers:read')")
    public ResponseEntity<List<Developer>> getAll(){
        return ResponseEntity.ok(developerService.getAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('developers:read')")
    public ResponseEntity<Developer> getById(@PathVariable Long id){
        return ResponseEntity.ok(developerService.getById(id));
    }

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('developers:write')")
    public ResponseEntity<Developer> createDeveloper(@RequestBody Developer developer){
        return ResponseEntity.ok(developerService.createDeveloper(developer));
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('developers:write')")
    public void deleteById(@PathVariable Long id){
        developerService.deleteById(id);
    }
}
