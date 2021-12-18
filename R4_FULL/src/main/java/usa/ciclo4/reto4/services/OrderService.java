/** < - - - - - - - - { G3 - Sergio Silva } - - - - - - - - > */


package usa.ciclo4.reto4.services;

import usa.ciclo4.reto4.models.Order;
import usa.ciclo4.reto4.repositories.OrderRepo;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.MongoTemplate;
import usa.ciclo4.reto4.models.User;




@Service
public class OrderService {
    
    /** < - - - - - - - - { Atributos } - - - - - - - - > */
    @Autowired
    private OrderRepo repository;

    @Autowired
    private MongoTemplate mongoTemplate;



    /** < - - - - - - - - { Metodos } - - - - - - - - > */
    
    
    // < CREATE - NEW ORDER >
    public Order save(Order order) {
        if (order.getRegisterDay() == null || order.getStatus() == null ||
        order.getSalesMan() == null || order.getProducts() == null ||
        order.getQuantities() == null) {
            return order;
            
        } else {
            order.setId(getID());
            return repository.save(order);
        }
        
    }
    
    // < READ - AMOUNT USERS>
    public int getAmount() {
        return repository.getAmount();
    }
    
    // < GET - ID EXISTS >
    public boolean getIdExists(Integer id) {
        return repository.getById(id).isPresent();
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
                Optional<Order> exist = repository.getById(i);
                if (exist.isEmpty()) {
                    return i;

                }

            } return 0;
            
        }
        
    }
    
    // < READ - ALL ORDERS >
    public List<Order> getAll() {
        return repository.getAll();
    }
    
    // < READ - ORDER BY ID >
    public Order getByID(Integer id) {
        Optional<Order> exists = repository.getById(id);
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
            Optional<Order> exists = repository.getById(order.getId());
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
    
    

    // < READ - USERS BY ID >
    public List<Order> getUsersById(Integer id) {
        return repository.getByUserId(id);
    }

    // < READ - USERS BY STATUS >
    public List<Order> getOrderByStatus(String status) {
        return repository.getByStatus(status);
    }

    public List<Order> getByStatusAndByUserId(String state, Integer id) {
        Query query = new Query();
        Criteria criterio = Criteria.where("salesMan.id").is(id)
                .and("status").is(state);

        query.addCriteria(criterio);

        List<Order> orders = mongoTemplate.find(query,Order.class);

        return orders;
    }
    
    // < GET - ORDER BY DATE >
    public List<Order> getByDate(String date) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Query query = new Query();

        Criteria dateCriteria = Criteria.where("registerDay")
            .gte(LocalDate.parse(date, dateFormat).minusDays(1).atStartOfDay())
            .lt(LocalDate.parse(date, dateFormat).plusDays(1).atStartOfDay());

        query.addCriteria(dateCriteria);

        List<Order> orders = mongoTemplate.find(query,Order.class);

        return orders;
        
    }

    // < READ - User By ID AND ORDER BY DATE>
    public List<Order> ordersSalesManByDate(String date, Integer id) {
        
        
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Query query = new Query();

        Criteria dateCriteria = Criteria.where("registerDay")
                .gte(LocalDate.parse(date, dateFormat).minusDays(1).atStartOfDay())
                .lt(LocalDate.parse(date, dateFormat).plusDays(1).atStartOfDay())
                .and("salesMan.id").is(id);

        query.addCriteria(dateCriteria);

        List<Order> orders = mongoTemplate.find(query,Order.class);

        return orders;
        
    }
    
    // < DELETE - BY ID >
    public boolean deleteById(Integer id) {
        Optional<Order> exists = repository.getById(id);
        if (exists.isPresent()) {
            repository.deleteById(id);
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
    
    // < DELETE - BY ORDER >
    public boolean deleteByOrder(Order order) {
        try {
            repository.deleteByOrder(order);
            return true;
            
        } catch (Exception e) {
            return false;
            
        }
        
    }

}

