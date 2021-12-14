/** < - - - - - - - - { G3 - Sergio Silva } - - - - - - - - > */

package usa.ciclo4.reto2.repositories;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.ciclo4.reto2.models.Order;
import usa.ciclo4.reto2.models.User;
import usa.ciclo4.reto2.repositories.crud.OrderInterface;


@Repository
public class OrderRepo {
    
    /** < - - - - - - - - { Atributos } - - - - - - - - > */
    @Autowired
    private OrderInterface crudRepo;
    
    
    
    /** < - - - - - - - - { Metodos } - - - - - - - - > */
    
    // < CREATE - UPDATE >
    public Order save(Order order) {
        return crudRepo.save(order);
    }
    
    // < READ - ALL >
    public List<Order> getAll() {
        return crudRepo.findAll();
    }
    
    // < READ - ZONE >
    public List<Order> getUserByZone(String zone) {
        return crudRepo.findUserByZone(zone);
    }
    
    // < READ - ID >
    public Optional<Order> getByID(Integer id) {
        return crudRepo.findById(id);
    }
    
    // <DELETE >
    public void deleteByID(Integer id) {
        crudRepo.deleteById(id);
    }
    
    
    
}


