package io.github.ianfairman.example.jpa.liquibase.entity;

import io.github.ianfairman.example.jpa.liquibase.value.FirstName;
import io.github.ianfairman.example.jpa.liquibase.value.IndividualId;
import javax.persistence.Transient;

/**
 *
 * @author Ian Fairman (ian.fairman@kymab.com)
 */
public interface Individual {

    Family getFamily();

    @Transient
    FirstName getFirstName();

    @Transient
    IndividualId getId();

    void setFamily(Family family);

    @Transient
    void setFirstName(FirstName firstName);

    @Transient
    void setId(IndividualId id);

}
