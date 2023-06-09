package de.htwberlin.webtech.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRespository extends JpaRepository<PersonEntity, Long> {
    List<PersonEntity> findAllByFirstName(String firstName);
}
