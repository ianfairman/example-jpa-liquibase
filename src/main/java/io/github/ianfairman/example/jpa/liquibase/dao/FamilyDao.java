package io.github.ianfairman.example.jpa.liquibase.dao;

import io.github.ianfairman.example.jpa.liquibase.entity.Family;
import io.github.ianfairman.example.jpa.liquibase.value.LastName;
import java.util.List;

public interface FamilyDao {

    Family create(LastName lastName);

    List<Family> findAll();

    Family findById(int id);

    List<Family> findByLastName(LastName lastName);

}
