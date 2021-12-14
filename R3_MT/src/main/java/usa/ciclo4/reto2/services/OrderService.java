/** < - - - - - - - - { G3 - Sergio Silva } - - - - - - - - > */

package usa.ciclo4.reto2.services;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.ciclo4.reto2.models.Order;
import usa.ciclo4.reto2.repositories.OrderRepo;



@Service
public class OrderService {
    
    /** < - - - - - - - - { Atributos } - - - - - - - - > */
    @Autowired
    private OrderRepo repository;
    
    
    
    /** < - - - - - - - - { Metodos } - - - - - - - - > */
    
    
    // < CREATE - NEW ORDER >
    public Order save(Order order) {
        if (order.getRegisterDay() == null || order.getStatus() == null ||
        order.getSalesMan() == null || order.getProducts() == null ||
        order.getQuantities() == null) {
            return order;
            
        } else {
            Optional<Order> exists = repository.getByID(order.getId());
            if (exists.isEmpty()) {
                return repository.save(order);
                
            } else {
                return order;
                
            }
        }
        
    }
    
    
    // < READ - ALL ORDERS >
    public List<Order> getAll() {
        return repository.getAll();
    }
    
    // < READ - ORDER BY ID >
    public Order getByID(Integer id) {
        Optional<Order> exists = repository.getByID(id);
        if (exists.isPresent()) {
            return exists.get();
                    
        } return new Order();
    }
    
    // < READ - USERS BY ZONE >
    public List<Order> getUsersByZone(String zone) {
        return repository.getUserByZone(zone);
    }
    
    // < UPDATE >
    public Order update(Order order){
        if(order.getId() != null){
            Optional<Order> exists = repository.getByID(order.getId());
            if(exists.isPresent()){
                if(order.getRegisterDay()!= null){
                    exists.get().setRegisterDay(order.getRegisterDay());
                }
                if(order.getStatus()!= null){
                    exists.get().setStatus(order.getStatus());
                }
                if(order.getSalesMan() != null){
                    exists.get().setSalesMan(order.getSalesMan());
                }
                if(order.getProducts()!= null){
                    exists.get().setProducts(order.getProducts());
                }
                if(order.getQuantities()!= null){
                    exists.get().setQuantities(order.getQuantities());
                }
                
                return repository.save(exists.get());
                
            } return order;
            
        } return order;
        
    }
    
    
    // <DELETE>
    public boolean delete(Integer id) {
        Optional<Order> exists = repository.getByID(id);
        if (exists.isPresent()) {
            repository.deleteByID(id);
            return true;
            
        } return false;
        
    }
    
}


