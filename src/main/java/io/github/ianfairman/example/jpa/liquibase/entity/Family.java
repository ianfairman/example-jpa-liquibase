package io.github.ianfairman.example.jpa.liquibase.entity;

import io.github.ianfairman.example.jpa.liquibase.value.FamilyId;
import io.github.ianfairman.example.jpa.liquibase.value.LastName;
import java.util.List;
import javax.persistence.Transient;

/**
 *
 * @author Ian Fairman (ian.fairman@kymab.com)
 */
public interface Family {

    @Transient
    FamilyId getId();

    List<Individual> getIndividualList();

    @Transient
    LastName getLastName();

    @Transient
    void setId(FamilyId id);

    void setIndividualList(List<Individual> individualList);

    @Transient
    void setLastName(LastName lastName);

}
