package io.github.ianfairman.example.jpa.liquibase.dao;

import io.github.ianfairman.example.jpa.liquibase.dao.FamilyDao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import io.github.ianfairman.example.jpa.liquibase.entity.Family;
import static io.github.ianfairman.example.jpa.liquibase.value.FamilyId.familyId;
import static io.github.ianfairman.example.jpa.liquibase.value.LastName.lastName;

public class FamilyDaoTest {

    private static FamilyDao familyDao;
    private static EntityManager entityManager;
    
    @BeforeClass
    public static void configureDao() {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("people");
        entityManager = emf.createEntityManager();
        familyDao = new FamilyDao(entityManager);
    }

    @Test
    public void shouldRetrieveAllFamiliesForFindAll() {
        // When
        List<Family> families = familyDao.findAll();
        
        // Then
        assertThat(families.get(0).getId(), is(equalTo(familyId(0))));
        assertThat(families.get(0).getLastName(), is(equalTo(lastName("Rubble"))));
        assertThat(families.get(1).getId(), is(equalTo(familyId(1))));
        assertThat(families.get(1).getLastName(), is(equalTo(lastName("Simpson"))));
        assertThat(families.get(2).getId(), is(equalTo(familyId(2))));
        assertThat(families.get(2).getLastName(), is(equalTo(lastName("Flintstone"))));
    }
    
    @Test
    public void shouldRetrieveSimpsonById1() {
        // When
        Family family = familyDao.findById(1);
        
        // Then
        assertThat(family.getId(), is(equalTo(familyId(1))));
        assertThat(family.getLastName(), is(equalTo(lastName("Simpson"))));
    }
    
    @Test
    public void shouldRetrieveSimpsonByName() {
        // When
        Family family = familyDao.findByLastName(lastName("Simpson")).get(0);
        
        // Then
        assertThat(family.getId(), is(equalTo(familyId(1))));
        assertThat(family.getLastName(), is(equalTo(lastName("Simpson"))));
    }
    
    @Test
    public void shouldCreateANewFamily() {
        // When
        entityManager.getTransaction().begin();
        Family family = familyDao.create(lastName("Bear"));
        entityManager.getTransaction().commit();
        
        // Then
        System.out.println(family);
    }
}
