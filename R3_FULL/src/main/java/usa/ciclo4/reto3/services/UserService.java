/** < - - - - - - - - { G3 - Sergio Silva } - - - - - - - - > */


package usa.ciclo4.reto3.services;

import usa.ciclo4.reto3.models.User;
import usa.ciclo4.reto3.repositories.UserRepo;


import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
            if (repository.getByEmail(user.getEmail()).isEmpty()) {
                
                user.setId(getID());
                return repository.save(user);
                
                
            } return user;
            
        }
        
    }
    
    
    // < READ - ALL USERS >
    public List<User> getAll() {
        return repository.getAll();
    }
    
    // < GET - BY ID >
    public User getById(Integer id) {
        Optional<User> user = repository.getById(id);
        if (user.isPresent()) {
            return user.get();
            
        } return new User();
    }
    
    // < GET - ID EXISTS >
    public boolean getIdExists(Integer id) {
        return repository.getById(id).isPresent();
    }
    
    // < READ - AMOUNT USERS>
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
                Optional<User> exist = repository.getById(i);
                if (exist.isEmpty()) {
                    return i;

                }

            } return 0;
            
        }
        
    }
    
    
    // < GET - EMAIL EXISTS >
    public boolean getEmailExists(String email) {
        return repository.getByEmail(email).isPresent();
    }
    
    // < GET - BY EMAIL >
    public User getUserByEmail(String email) {
        Optional<User> exists = repository.getByEmail(email);
        
        if (exists.isPresent()) {
            return exists.get();
            
        } return new User();
        
    }
    
    
    // < GET - EMAIL AND PASSWORD EXISTS >
    public boolean getEmailAndPasswordExists(String email, String password) {
        return repository.getByEmailAndPassword(email, password).isPresent();   
    }
    
    // < GET - BY EMAIL AND PASSWORD >
    public User getUserByEmailAndPassword(String email, String password) {
        Optional<User> user = repository.getByEmailAndPassword(email, password);
        
        if (user.isPresent()) {
            return user.get();
            
        } return new User();
        
    }
    
    
    
    // <UPDATE>
    public User update(User user){
        if(user.getId()!=null){
            Optional<User> userExist = repository.getById(user.getId());
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
                return repository.save(userExist.get());
                
            } return user;
            
        } return user;
        
    }
    
    
    // < DELETE - BY ID >
    public boolean deleteById(Integer id) {
        Optional<User> user = repository.getById(id);
        if (user.isPresent()) {
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
    
    // < DELETE - BY USER >
    public boolean deleteByUser(User user) {
        try {
            repository.deleteByUser(user);
            return true;
            
        } catch (Exception e) {
            return false;
            
        }
        
    }
    
}


