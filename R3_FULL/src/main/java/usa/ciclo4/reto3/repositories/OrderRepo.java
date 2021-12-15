/** < - - - - - - - - { G3 - Sergio Silva } - - - - - - - - > */

package usa.ciclo4.reto3.repositories;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.ciclo4.reto3.models.Order;
import usa.ciclo4.reto3.models.User;
import usa.ciclo4.reto3.repositories.crud.OrderInterface;


@Repository
public class OrderRepo {
    
    /** < - - - - - - - - { Atributos } - - - - - - - - > */
    @Autowired
    private OrderInterface crudRepo;
    
    
    
    /** < - - - - - - - - { Metodos } - - - - - - - - > */
    
    // < POST - PUT >
    public Order save(Order order) {
        return crudRepo.save(order);
    }
    
    // < GET - ALL >
    public List<Order> getAll() {
        return crudRepo.findAll();
    }
    
    // < GET - AMOUNT >
    public int getAmount() {
        return (int) crudRepo.count();
    }
    
    // < GET - ORDER BY USER.ZONE >
    public List<Order> getUserByZone(String zone) {
        return crudRepo.findUserByZone(zone);
    }
    
    // < GET - ORDER BY ID >
    public Optional<Order> getByID(Integer id) {
        return crudRepo.findById(id);
    }
    
    // < GET - USER BY ID >
    public List<Order> getOrderBySalesmanId(Integer id) { 
        return crudRepo.findBySalesManId(id);
    }
    

    // < GET - USER BY STATUS >
    public List<Order> getOrderByStatus(String status) {
        return crudRepo.findByStatus(status);
    }
    
    // < DELETE - ORDER BY ID >
    public void deleteByID(Integer id) {
        crudRepo.deleteById(id);
    }
    
    // < DELETE - ORDER >
    public void deleteByOrder(Order order) {
        crudRepo.delete(order);
    }
    
    // < DELETE - ALL >
    public void deleteAll() {
        crudRepo.deleteAll();
    }
    
    
    
    
    
}


