package io.github.ianfairman.example.jpa.liquibase.dao;

import io.github.ianfairman.example.jpa.liquibase.entity.Individual;
import java.util.List;

public interface IndividualDao {

    List<Individual> findAll();

    List<Individual> findByFirstName(String firstName);

    Individual findById(int id);

}
