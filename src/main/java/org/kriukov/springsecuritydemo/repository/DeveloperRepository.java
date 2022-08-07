package org.kriukov.springsecuritydemo.repository;

import org.kriukov.springsecuritydemo.model.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> {
}
