package io.github.ianfairman.family.entity;

import io.github.ianfairman.family.value.FamilyId;
import io.github.ianfairman.family.value.LastName;
import java.util.List;
import javax.persistence.Transient;

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
