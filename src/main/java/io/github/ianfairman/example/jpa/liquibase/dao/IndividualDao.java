package io.github.ianfairman.example.jpa.liquibase.dao;

import io.github.ianfairman.example.jpa.liquibase.entity.Individual;
import io.github.ianfairman.example.jpa.liquibase.value.FirstName;
import java.util.List;

public interface IndividualDao {

    List<Individual> findAll();

    List<Individual> findByFirstName(FirstName firstName);

    Individual findById(int id);

}
