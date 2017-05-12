package io.github.ianfairman.example.jpa.liquibase.dao;

import io.github.ianfairman.family.dao.IndividualDao;
import io.github.ianfairman.family.dao.jpa.IndividualDaoJpa;
import io.github.ianfairman.family.entity.Individual;
import static io.github.ianfairman.family.value.FirstName.firstName;
import static io.github.ianfairman.family.value.IndividualId.individualId;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;

public class IndividualDaoJpaTest {

    private static IndividualDao individualDao;

    @BeforeClass
    public static void configureDao() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("people");
        EntityManager em = emf.createEntityManager();
        individualDao = new IndividualDaoJpa(em);
    }

    @Test
    public void shouldRetrieveAllindividualsForFindAll() {
        // When
        List<Individual> individuals = individualDao.findAll();

        // Then
        assertThat(individuals.get(0).getId(), equalTo(individualId(0)));
        assertThat(individuals.get(0).getFirstName(), equalTo(firstName("Bart")));
        assertThat(individuals.get(1).getId(), equalTo(individualId(1)));
        assertThat(individuals.get(1).getFirstName(), equalTo(firstName("Homer")));
        assertThat(individuals.get(2).getId(), equalTo(individualId(2)));
        assertThat(individuals.get(2).getFirstName(), equalTo(firstName("Marge")));
    }

    @Test
    public void shouldRetrieveHomerById1() {
        // When
        Individual individual = individualDao.findById(individualId(1));

        // Then
        assertThat(individual.getId(), equalTo(individualId(1)));
        assertThat(individual.getFirstName(), equalTo(firstName("Homer")));
    }

    @Test
    public void shouldRetrieveHomerByName() {
        // When
        Individual individual = individualDao.findByFirstName(firstName("Homer")).get(0);

        // Then
        assertThat(individual.getId(), equalTo(individualId(1)));
        assertThat(individual.getFirstName(), equalTo(firstName("Homer")));
    }
}
