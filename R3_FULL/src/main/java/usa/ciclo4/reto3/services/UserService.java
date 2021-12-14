
/** < - - - - - - - - { G3 - Sergio Silva } - - - - - - - - > */

package usa.ciclo4.reto3.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.ciclo4.reto3.models.Order;
import usa.ciclo4.reto3.models.User;
import usa.ciclo4.reto3.repositories.OrderRepo;
import usa.ciclo4.reto3.repositories.UserRepo;



@Service
public class UserService {
    
    /** < - - - - - - - - { Atributos } - - - - - - - - > */
    @Autowired
    private UserRepo repository;
    
    @Autowired
    private OrderRepo orderRepo;
    
    
    
    /** < - - - - - - - - { Metodos } - - - - - - - - > */
    
    
    // < CREATE - NEW USER >
    public User save(User user) {
        if (user.getIdentification() == null || user.getName()== null ||
        user.getMonthBirthtDay() == null || user.getAddress()== null ||
        user.getCellPhone()== null || user.getEmail()== null ||
        user.getPassword()== null || user.getZone()== null ||
        user.getType()== null) {
            return user;
            
        } else {
            List<User> userExist = repository.getUserByNameOrEmail(user.getName(), user.getEmail());
            if (userExist.isEmpty()) {
                if (user.getId() == null) {
                    return repository.saveUser(user);
                    
                } else {
                    Optional<User> userExist2 = repository.getUserById(user.getId());
                    if (userExist2.isEmpty()) {
                        return repository.saveUser(user);
                        
                    } else {
                        return user;
                        
                    }
                    
                }
                
            } else {
                return user;
                
            }
        }
        
    }
     
    
    // < READ - ALL >
    public List<User> getAll() {
        return repository.getAll();
    }
    
    // < READ - USER BY ID >
    public User getUserByID(Integer id) {
        Optional<User> user = repository.getUserById(id);
        if (user.isPresent()) {
            return user.get();
            
        } return new User();
    }
    
    // < GET - AMOUNT >
    public int getAmount() {
        return repository.getAmount();
    }
    
    // < ALGORITHM - GET MAX ID >
    private int getMaxID() {
        if (getAmount() == 0) {
            return 1;
            
        } else {
            List<User> users = repository.getAll();
            ArrayList<Integer> ids = new ArrayList<>();
            
            for (User user : users) {
                ids.add(user.getId());

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
                Optional<User> exist = repository.getUserById(i);
                if (exist.isEmpty()) {
                    return i;

                }

            } return 0;
            
        }
        
    }
    
    
    // < EXISTS - EMAIL >
    
    public boolean getUserByEmail(String email) {
        return repository.getUserByEmail(email).isPresent();
    }
    
    
    
    
    // < EXISTS - USER >
    public boolean getUserByEmailAndPassword(String email, String password) {
        return repository.getUserByEmailAndPassword(email, password).isPresent();
        
    }
    
    
    
    // < UPDATE >
    public User update(User user){
        if(user.getId()!=null){
            Optional<User> userExist = repository.getUserById(user.getId());
            if(userExist.isPresent()){
                if(user.getIdentification()!=null){
                    userExist.get().setIdentification(user.getIdentification());
                }
                if(user.getName()!=null){
                    userExist.get().setName(user.getName());
                }
                if(user.getMonthBirthtDay()!=null){
                    userExist.get().setMonthBirthtDay(user.getMonthBirthtDay());
                }
                if(user.getAddress()!=null){
                    userExist.get().setAddress(user.getAddress());
                }
                if(user.getCellPhone()!=null){
                    userExist.get().setCellPhone(user.getCellPhone());
                }
                if(user.getEmail()!=null){
                    userExist.get().setEmail(user.getEmail());
                }
                if(user.getPassword()!=null){
                    userExist.get().setPassword(user.getPassword());
                }
                if(user.getZone()!=null){
                    userExist.get().setZone(user.getZone());
                }
                if(user.getType()!=null){
                    userExist.get().setType(user.getType());
                }
                return repository.saveUser(userExist.get());
            }else{
                return user;
            }
        }else{
            return user;
        }
    }
    
    
    // < DELETE - BY ID >
    public boolean delete(Integer id) {
        Optional<User> user = repository.getUserById(id);
        if (user.isPresent()) {
            
            for (Order order : orderRepo.getOrderBySalesmanId(id)) {
                orderRepo.deleteByID(order.getId());
                
            }
            
            repository.deleteById(id);
            
            return true;
            
        } return false;
        
    }
    
    // < DELETE - ALL >
    public boolean deleteAll() {
        try {
            repository.deleteAll();
            orderRepo.deleteAll();
            return true;
            
        } catch (Exception e) {
            return false;
            
        }
        
    }
    
}


