package org.kriukov.springsecuritydemo.service;

import org.kriukov.springsecuritydemo.model.Developer;
import org.kriukov.springsecuritydemo.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeveloperService {

    @Autowired
    private DeveloperRepository developerRepository;

    public List<Developer> getAll(){
        return developerRepository.findAll();
    }

    public Developer getById(Long id){
        return developerRepository.findById(id).get();
    }

    public Developer createDeveloper(Developer developer){
        return developerRepository.save(developer);
    }

    public void deleteById(Long id){
        developerRepository.deleteById(id);
        //return developerRepository.getById(id);
    }
}
