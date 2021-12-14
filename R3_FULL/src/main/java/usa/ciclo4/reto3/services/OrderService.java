/** < - - - - - - - - { G3 - Sergio Silva } - - - - - - - - > */

package usa.ciclo4.reto3.services;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.ciclo4.reto3.models.Order;
import usa.ciclo4.reto3.models.User;
import usa.ciclo4.reto3.repositories.OrderRepo;



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
    
    // < ALGORITHM - GET MAX ID >
    private int getMaxID() {
        if (getAmount() == 0) {
            return 1;
            
        } else {
            List<Order> orders = repository.getAll();
            ArrayList<Integer> ids = new ArrayList<>();
            
            for (Order order : orders) {
                ids.add(order.getId());

            } Collections.sort(ids);
            
            return ids.get(ids.size() - 1) + 1;
            
        }
        
    }
    
    // < GET - ASIGN NEW ID >
    public int getID() {
        int maxID = getMaxID();
        if (maxID == 1) {
            return maxID;
                   
        } else {
            for (int i = 1; i <= maxID; i++) { 
                Optional<Order> exist = repository.getByID(i);
                if (exist.isEmpty()) {
                    return i;

                }

            } return 0;
            
        }
        
    }
    
    
    // < GET - ALL >
    public List<Order> getAll() {
        return repository.getAll();
    }
    
    // < GET - ORDER BY ID >
    public Order getByID(Integer id) {
        Optional<Order> exists = repository.getByID(id);
        if (exists.isPresent()) {
            return exists.get();
                    
        } return new Order();
    }
    
    // < GET - AMOUNT >
    public int getAmount() {
        return repository.getAmount();
    }
    
    // < GET - ORDERS BY USER.ZONE >
    public List<Order> getUsersByZone(String zone) {
        return repository.getUserByZone(zone);
    }
    
    // < GET - ORDER BY STATUS >
    public List<Order> getOrderByStatus(String status) {
        return repository.getOrderByStatus(status);
    }
    
    // < GET - USER BY ID >
    public List<Order> getOrderBySalesmanId(Integer id) { 
        return repository.getOrderBySalesmanId(id);
    }
    
    // < GET - ORDER BY PRODUCT ID >
    public List<Order> getByProductsId(Integer id) { 
        
        List<Order> ordenes1 = getAll();
        ArrayList<Order> ordenes2 = new ArrayList<>();
        
        for (Order order: ordenes1) {
            if (order.getProducts().containsKey(id.toString())) {
                ordenes2.add(order);
                
            }
            
        }
        
        return (List<Order>) ordenes2;
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
    
    // < DELETE - ALL >
    public boolean deleteAll() {
        try {
            repository.deleteAll();
            return true;
            
        } catch (Exception e) {
            return false;
            
        }
        
    }
    
}


