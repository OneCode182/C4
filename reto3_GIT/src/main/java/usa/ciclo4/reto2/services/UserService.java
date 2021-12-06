/** < - - - - - - - - { G3 - Sergio Silva } - - - - - - - - > */

package usa.ciclo4.reto2.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.ciclo4.reto2.models.User;
import usa.ciclo4.reto2.repositories.UserRepo;



@Service
public class UserService {
    
    /** < - - - - - - - - { Atributos } - - - - - - - - > */
    @Autowired
    private UserRepo repository;
    
    
    
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
    
    
    // < READ - ALL USERS >
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
    
    // < READ - AMOUNT USERS>
    public int getAmount() {
        return repository.getAmount();
    }
    
    private int getMaxID() {
        List<User> users = repository.getAll();
        ArrayList<Integer> ids = new ArrayList<>();
        for (User user : users) {
            ids.add(user.getId());

        } Collections.sort(ids);
        return ids.get(-1) + 1;
    }
    
    // <READ - ASIGN NEW ID>
    public int getID() {
        for (int i = 0; i <= getMaxID(); i++) { 
            Optional<User> exist = repository.getUserById(i);
            if (exist.isEmpty()) {
                return i;

            }

        } return -1;

    }
    
    
    // <EXISTS - EMAIL>
    
    public boolean getUserByEmail(String email) {
        return repository.getUserByEmail(email).isPresent();
    }
    
    
    
    
    // <EXISTS - USER>
    public User getUserByEmailAndPassword(String email, String password) {
        Optional<User> user = repository.getUserByEmailAndPassword(email, password);
        
        if (user.isPresent()) {
            return user.get();
            
        } return new User();
        
    }
    
    
    
    // <UPDATE>
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
    
    
    // <DELETE>
    public boolean delete(Integer id) {
        Optional<User> user = repository.getUserById(id);
        if (user.isPresent()) {
            repository.deleteUserById(id);
            return true;
            
        } return false;
        
    }
    
}


