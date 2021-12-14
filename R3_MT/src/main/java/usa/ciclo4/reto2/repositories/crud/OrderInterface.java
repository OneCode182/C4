/** < - - - - - - - - { G3 - Sergio Silva } - - - - - - - - > */


package usa.ciclo4.reto2.repositories.crud;


import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import usa.ciclo4.reto2.models.Order;




public interface OrderInterface extends MongoRepository<Order, Integer> {
    
    @Query("{'salesMan.zone' : ?0}")
    public List<Order> findUserByZone(String zone);
    
    
}


