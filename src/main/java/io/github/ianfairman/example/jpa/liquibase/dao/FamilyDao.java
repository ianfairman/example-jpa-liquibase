package io.github.ianfairman.example.jpa.liquibase.dao;

import java.util.List;
import static java.util.Objects.requireNonNull;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import io.github.ianfairman.example.jpa.liquibase.entity.Family;
import static io.github.ianfairman.example.jpa.liquibase.value.FamilyId.familyId;
import io.github.ianfairman.example.jpa.liquibase.value.LastName;

public class FamilyDao {

    private final EntityManager entityManager;
    
    public FamilyDao(EntityManager entityManager) {
        this.entityManager = requireNonNull(entityManager);
    }

    public List<Family> findAll() {
        return entityManager.createNamedQuery("Family.findAll", Family.class).getResultList();
    }
    
    public Family findById(int id) {
        TypedQuery<Family> query = entityManager.createNamedQuery("Family.findById", Family.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
    
    public List<Family> findByLastName(LastName lastName) {
        TypedQuery<Family> query = entityManager.createNamedQuery("Family.findByLastName", Family.class);
        query.setParameter("lastName", lastName.getValue());
        return query.getResultList();
    }
    
    public Family create(LastName lastName) {
        Family family = new Family();
        family.setLastName(lastName);
        entityManager.persist(family);
        entityManager.flush();
        entityManager.refresh(family);
        return family;
    }
}
