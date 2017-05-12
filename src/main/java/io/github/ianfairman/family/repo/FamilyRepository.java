package io.github.ianfairman.family.repo;

import io.github.ianfairman.family.entity.Family;
import io.github.ianfairman.family.value.FamilyId;
import io.github.ianfairman.family.value.LastName;
import java.util.List;

public interface FamilyRepository {

    Family create(LastName lastName);

    List<Family> findAll();

    Family findById(FamilyId id);

    List<Family> findByLastName(LastName lastName);

}
