package io.github.ianfairman.family.dao;

import io.github.ianfairman.family.entity.Individual;
import io.github.ianfairman.family.value.FirstName;
import io.github.ianfairman.family.value.IndividualId;
import java.util.List;

public interface IndividualDao {

    List<Individual> findAll();

    List<Individual> findByFirstName(FirstName firstName);

    Individual findById(IndividualId id);

}
