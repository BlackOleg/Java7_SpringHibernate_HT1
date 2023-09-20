package olegivanov.service;

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
        public List<Persons> getPersonsByCity(String city){

            return myRepository.getPersonsByCity(city.toUpperCase());
        }


    public List<Persons> getPersonsByAge() {
        return myRepository.getPersonsByAge();
    }
}
