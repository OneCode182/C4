/** < - - - - - - - - { G3 - Sergio Silva } - - - - - - - - > */

package usa.ciclo4.reto5.repositories;

import usa.ciclo4.reto5.models.Order;
import usa.ciclo4.reto5.repositories.crud.OrderInterface;


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
    
    // <READ - AMOUNT USERS>
    public int getAmount() {
        return (int) crudRepo.count();
    }
    
    
    
    // < READ - ID >
    public Optional<Order> getById(Integer id) {
        return crudRepo.findById(id);
    }
    
    // < READ - ZONE >
    public List<Order> getUserByZone(String zone) {
        return crudRepo.findByUserZone(zone);
    }

    // < READ - User By id >
    public List<Order> getByUserId(Integer id) { 
        return crudRepo.findByUserId(id);
    }

    // < READ - User By Status>
    public List<Order> getByStatus(String status) {
        return crudRepo.findByStatus(status);
    }
    
    
    // < DELETE - BY USER OBJECT >
    public void deleteByOrder(Order order) {
        crudRepo.delete(order);
    }
    
    // < DELETE - BY ID >
    public void deleteById(Integer id) {
        crudRepo.deleteById(id);
    }
    
    // < DELETE - ALL >
    public void deleteAll() {
        crudRepo.deleteAll();
    }




}


