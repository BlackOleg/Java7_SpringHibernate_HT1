package olegivanov.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import olegivanov.entity.City;
import olegivanov.entity.PersonId;
import olegivanov.entity.Persons;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class MyRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public MyRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Transactional
    public void savePersons(Persons persons){
        entityManager.persist(persons);
    }
    @Transactional
    public void saveCity(City city){
        entityManager.persist(city);
    }
    @Transactional
    public List<Persons> getPersonsByCity(String city) {
        String sql = "SELECT * FROM myhometask.persons";
        TypedQuery<Persons> query = entityManager.createQuery(sql, Persons.class);

        return query.getResultList();
    }


    public List<Persons> getPersonsByAge() {
        return List.of(new Persons());
    }
}
