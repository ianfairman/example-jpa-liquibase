package io.github.ianfairman.family.repo.jpa;

import io.github.ianfairman.family.entity.Individual;
import io.github.ianfairman.family.value.FirstName;
import io.github.ianfairman.family.value.IndividualId;
import java.util.List;
import static java.util.Objects.requireNonNull;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import io.github.ianfairman.family.repo.IndividualRepository;

public class IndividualRepositoryJpa implements IndividualRepository {

    private final EntityManager entityManager;

    public IndividualRepositoryJpa(EntityManager entityManager) {
        this.entityManager = requireNonNull(entityManager);
    }

    @Override
    public List<Individual> findAll() {
        return entityManager.createNamedQuery("IndividualJpa.findAll", Individual.class).getResultList();
    }

    @Override
    public Individual findById(IndividualId id) {
        TypedQuery<Individual> query = entityManager.createNamedQuery("IndividualJpa.findById", Individual.class);
        query.setParameter("id", id.getValue());
        return query.getSingleResult();
    }

    @Override
    public List<Individual> findByFirstName(FirstName firstName) {
        TypedQuery<Individual> query = entityManager.createNamedQuery("IndividualJpa.findByFirstName", Individual.class);
        query.setParameter("firstName", firstName);
        return query.getResultList();
    }
}
