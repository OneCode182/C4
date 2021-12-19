/** < - - - - - - - - { G3 - Sergio Silva } - - - - - - - - > */


package usa.ciclo4.reto3.repositories.crud;

import usa.ciclo4.reto3.models.Order;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;





public interface OrderInterface extends MongoRepository<Order, Integer> {
    
    @Query("{'salesMan.zone' : ?0}")
    public List<Order> findByUserZone(String zone);

    @Query("{'salesMan.id' : ?0}")
    public List<Order> findByUserId(Integer id);

    public List<Order> findByStatus(String status);
    
}


