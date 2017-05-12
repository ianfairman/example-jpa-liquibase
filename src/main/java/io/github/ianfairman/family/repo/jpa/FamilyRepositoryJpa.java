package io.github.ianfairman.family.repo.jpa;

import io.github.ianfairman.family.entity.Family;
import io.github.ianfairman.family.entity.jpa.FamilyJpa;
import io.github.ianfairman.family.value.FamilyId;
import io.github.ianfairman.family.value.LastName;
import java.util.List;
import static java.util.Objects.requireNonNull;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import io.github.ianfairman.family.repo.FamilyRepository;

public class FamilyRepositoryJpa implements FamilyRepository {

    private final EntityManager entityManager;

    public FamilyRepositoryJpa(EntityManager entityManager) {
        this.entityManager = requireNonNull(entityManager);
    }

    @Override
    public List<Family> findAll() {
        return entityManager.createNamedQuery("FamilyJpa.findAll", Family.class).getResultList();
    }

    @Override
    public Family findById(FamilyId id) {
        TypedQuery<Family> query = entityManager.createNamedQuery("FamilyJpa.findById", Family.class);
        query.setParameter("id", id.getValue());
        return query.getSingleResult();
    }

    @Override
    public List<Family> findByLastName(LastName lastName) {
        TypedQuery<Family> query = entityManager.createNamedQuery("FamilyJpa.findByLastName", Family.class);
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }

    @Override
    public Family create(LastName lastName) {
        FamilyJpa family = new FamilyJpa();
        family.setLastName(lastName);
        entityManager.persist(family);
        entityManager.flush();
        entityManager.refresh(family);
        return family;
    }
}
