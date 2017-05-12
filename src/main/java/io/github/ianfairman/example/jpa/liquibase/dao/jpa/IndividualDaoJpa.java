package io.github.ianfairman.example.jpa.liquibase.dao.jpa;

import io.github.ianfairman.example.jpa.liquibase.dao.IndividualDao;
import io.github.ianfairman.example.jpa.liquibase.entity.Individual;
import java.util.List;
import static java.util.Objects.requireNonNull;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class IndividualDaoJpa implements IndividualDao {

    private final EntityManager entityManager;

    public IndividualDaoJpa(EntityManager entityManager) {
        this.entityManager = requireNonNull(entityManager);
    }

    @Override
    public List<Individual> findAll() {
        return entityManager.createNamedQuery("IndividualJpa.findAll", Individual.class).getResultList();
    }

    @Override
    public Individual findById(int id) {
        TypedQuery<Individual> query = entityManager.createNamedQuery("IndividualJpa.findById", Individual.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<Individual> findByFirstName(String firstName) {
        TypedQuery<Individual> query = entityManager.createNamedQuery("IndividualJpa.findByFirstName", Individual.class);
        query.setParameter("firstName", firstName);
        return query.getResultList();
    }
}