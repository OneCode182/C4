/** < - - - - - - - - { G3 - Sergio Silva } - - - - - - - - > */


package usa.ciclo4.reto3.repositories.crud;


import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import usa.ciclo4.reto3.models.Order;




public interface OrderInterface extends MongoRepository<Order, Integer> {
    
    @Query("{'salesMan.zone' : ?0}")
    public List<Order> findUserByZone(String zone);
    
    @Query("{'salesMan.id' : ?0}")
    public List<Order> findBySalesManId(Integer id);
    
    public List<Order> findByStatus(String status);
    
    
}


