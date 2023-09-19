package olegivanov.service;

import olegivanov.repository.MyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebService {

        private final MyRepository myRepository;

        public WebService(MyRepository myRepository) {
            this.myRepository = myRepository;
        }
        public List<String> getProductsByName(String name){

            return myRepository.getProductsByName(name.toLowerCase());
        }


}
