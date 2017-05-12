package io.github.ianfairman.family.entity;

import io.github.ianfairman.family.value.FirstName;
import io.github.ianfairman.family.value.IndividualId;
import javax.persistence.Transient;

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
