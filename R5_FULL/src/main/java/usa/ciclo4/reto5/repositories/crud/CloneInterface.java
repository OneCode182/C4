/** < - - - - - - - - { G3 - Sergio Silva } - - - - - - - - > */


package usa.ciclo4.reto5.repositories.crud;

import java.util.List;
import usa.ciclo4.reto5.models.Clone;
import org.springframework.data.mongodb.repository.MongoRepository;





public interface CloneInterface extends MongoRepository<Clone, Integer> {
    
    
    // < GET - BY PRICE >
    public List<Clone> findByPrice(double price);
    
}


