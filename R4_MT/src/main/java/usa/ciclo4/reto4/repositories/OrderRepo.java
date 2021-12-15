/** < - - - - - - - - { G3 - Sergio Silva } - - - - - - - - > */

package usa.ciclo4.reto4.repositories;

import usa.ciclo4.reto4.models.Order;
import usa.ciclo4.reto4.repositories.crud.OrderInterface;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


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

    // < READ - User By id >
    public List<Order> getUserById(Integer id) { 
        return crudRepo.findUserById(id);
    }

    // < READ - User By Status>
    public List<Order> getOrderByStatus(String status) {
        return crudRepo.findByStatus(status);
    }




}


