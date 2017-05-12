package io.github.ianfairman.family.repo.jpa;

import io.github.ianfairman.family.repo.jpa.FamilyRepositoryJpa;
import io.github.ianfairman.family.entity.Family;
import static io.github.ianfairman.family.value.FamilyId.familyId;
import static io.github.ianfairman.family.value.LastName.lastName;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import io.github.ianfairman.family.repo.FamilyRepository;

public class FamilyRepositoryJpaTest {

    private static FamilyRepository familyDao;
    private static EntityManager entityManager;

    @BeforeClass
    public static void configureDao() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("people");
        entityManager = emf.createEntityManager();
        familyDao = new FamilyRepositoryJpa(entityManager);
    }

    @Test
    public void shouldRetrieveAllFamiliesForFindAll() {
        // When
        List<Family> families = familyDao.findAll();

        // Then
        assertThat(families.get(0).getId(), equalTo(familyId(0)));
        assertThat(families.get(0).getLastName(), equalTo(lastName("Rubble")));
        assertThat(families.get(1).getId(), equalTo(familyId(1)));
        assertThat(families.get(1).getLastName(), equalTo(lastName("Simpson")));
        assertThat(families.get(2).getId(), equalTo(familyId(2)));
        assertThat(families.get(2).getLastName(), equalTo(lastName("Flintstone")));
    }

    @Test
    public void shouldRetrieveSimpsonById1() {
        // When
        Family family = familyDao.findById(familyId(1));

        // Then
        assertThat(family.getId(), equalTo(familyId(1)));
        assertThat(family.getLastName(), equalTo(lastName("Simpson")));
    }

    @Test
    public void shouldRetrieveSimpsonByName() {
        // When
        Family family = familyDao.findByLastName(lastName("Simpson")).get(0);

        // Then
        assertThat(family.getId(), equalTo(familyId(1)));
        assertThat(family.getLastName(), equalTo(lastName("Simpson")));
    }

    @Test
    public void shouldCreateANewFamily() {
        // When
        entityManager.getTransaction().begin();
        Family family = familyDao.create(lastName("Bear"));
        entityManager.getTransaction().commit();

        // Then
        List<Family> families = familyDao.findByLastName(lastName("Bear"));
        assertThat(families.get(0), equalTo(family));
    }
}
