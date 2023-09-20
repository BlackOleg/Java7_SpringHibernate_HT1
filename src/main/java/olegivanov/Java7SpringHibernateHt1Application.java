package olegivanov;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import olegivanov.entity.City;
import olegivanov.entity.PersonId;
import olegivanov.entity.Persons;
import olegivanov.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Java7SpringHibernateHt1Application implements CommandLineRunner {
    @Autowired
    private MyRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Java7SpringHibernateHt1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        //var city1= City.builder().name("LONDON").build();
        //repository.saveCity(city1);
//        createData();

    }

    public void createData() {
        var person1 = Persons.builder()
                .personId(PersonId.builder()
                        .name("Vasiliy")
                        .surname("Potemkin")
                        .age(50)
                        .build())
                .phone_number("+75550009623")
                .city_of_living(City.builder().name("MOSCOW").build())
                .build();
        var person2 = Persons.builder()
                .personId(PersonId.builder()
                        .name("Liliya")
                        .surname("Belova")
                        .age(22)
                        .build())
                .phone_number("+75550009777")
                .city_of_living(City.builder().name("MOSCOW").build())
                .build();
        var person3 = Persons.builder()
                .personId(PersonId.builder()
                        .name("Olga")
                        .surname("Svetlova")
                        .age(25)
                        .build())
                .phone_number("+755500099999")
                .city_of_living(City.builder().name("ST.PETERSBURG").build())
                .build();
        List.of(person1, person2, person3).forEach(p -> repository.savePersons(p));
    }
}
