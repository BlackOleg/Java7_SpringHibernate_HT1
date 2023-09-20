package olegivanov.service;

import olegivanov.entity.City;
import olegivanov.entity.Persons;
import olegivanov.repository.MyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebService {

        private final MyRepository myRepository;

        public WebService(MyRepository myRepository) {
            this.myRepository = myRepository;
        }
        public List<City> getPersonsByCity(String city){
            return myRepository.getPersonsByCity(city.toUpperCase());
        }


}
