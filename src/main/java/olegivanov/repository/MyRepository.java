package olegivanov.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import olegivanov.entity.City;
import olegivanov.entity.PersonId;
import olegivanov.entity.Persons;
import org.hibernate.graph.GraphParser;
import org.hibernate.graph.RootGraph;
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
    public void savePersons(Persons persons) {
        entityManager.persist(persons);
    }

    @Transactional
    public void saveCity(City city) {
        entityManager.persist(city);
    }


    public List<City> getPersonsByCity(String city) {
        String hql = "from Persons p where city_of_living.name = :name";
        Query q = entityManager.createQuery(hql, Persons.class).setParameter("name", city);
        return q.getResultList();
    }

}
