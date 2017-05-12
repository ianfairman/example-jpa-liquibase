package io.github.ianfairman.example.jpa.liquibase.dao.jpa;

import io.github.ianfairman.example.jpa.liquibase.dao.FamilyDao;
import io.github.ianfairman.example.jpa.liquibase.entity.Family;
import io.github.ianfairman.example.jpa.liquibase.entity.jpa.FamilyJpa;
import io.github.ianfairman.example.jpa.liquibase.value.LastName;
import java.util.List;
import static java.util.Objects.requireNonNull;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class FamilyDaoJpa implements FamilyDao {

    private final EntityManager entityManager;

    public FamilyDaoJpa(EntityManager entityManager) {
        this.entityManager = requireNonNull(entityManager);
    }

    @Override
    public List<Family> findAll() {
        return entityManager.createNamedQuery("FamilyJpa.findAll", Family.class).getResultList();
    }

    @Override
    public Family findById(int id) {
        TypedQuery<Family> query = entityManager.createNamedQuery("FamilyJpa.findById", Family.class);
        query.setParameter("id", id);
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
