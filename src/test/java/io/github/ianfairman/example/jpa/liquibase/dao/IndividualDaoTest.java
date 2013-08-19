package io.github.ianfairman.example.jpa.liquibase.dao;

import io.github.ianfairman.example.jpa.liquibase.dao.IndividualDao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import static io.github.ianfairman.example.jpa.liquibase.value.FirstName.firstName;
import io.github.ianfairman.example.jpa.liquibase.entity.Individual;
import static io.github.ianfairman.example.jpa.liquibase.value.IndividualId.individualId;

public class IndividualDaoTest {
    
    private static IndividualDao individualDao;
    
    @BeforeClass
    public static void configureDao() {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("people");
        EntityManager em = emf.createEntityManager();
        individualDao = new IndividualDao(em);
    }

    @Test
    public void shouldRetrieveAllindividualsForFindAll() {
        // When
        List<Individual> individuals = individualDao.findAll();
        
        // Then
        assertThat(individuals.get(0).getId(), is(equalTo(individualId(0))));
        assertThat(individuals.get(0).getFirstName(), is(equalTo(firstName("Bart"))));
        assertThat(individuals.get(1).getId(), is(equalTo(individualId(1))));
        assertThat(individuals.get(1).getFirstName(), is(equalTo(firstName("Homer"))));
        assertThat(individuals.get(2).getId(), is(equalTo(individualId(2))));
        assertThat(individuals.get(2).getFirstName(), is(equalTo(firstName("Marge"))));
    }
    
    @Test
    public void shouldRetrieveHomerById1() {
        // When
        Individual individual = individualDao.findById(1);
        
        // Then
        assertThat(individual.getId(), is(equalTo(individualId(1))));
        assertThat(individual.getFirstName(), is(equalTo(firstName("Homer"))));
    }
    
    @Test
    public void shouldRetrieveHomerByName() {
        // When
        Individual individual =  individualDao.findByFirstName("Homer").get(0);
        
        // Then
        assertThat(individual.getId(), is(equalTo(individualId(1))));
        assertThat(individual.getFirstName(), is(equalTo(firstName("Homer"))));
    }
}
