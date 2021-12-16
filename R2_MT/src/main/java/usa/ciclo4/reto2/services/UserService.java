/** < - - - - - - - - { G3 - Sergio Silva } - - - - - - - - > */

package usa.ciclo4.reto2.services;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.ciclo4.reto2.models.User;
import usa.ciclo4.reto2.repositories.UserRepo;



@Service
public class UserService {
    
    /** < - - - - - - - - { Atributos } - - - - - - - - > */
    @Autowired
    private UserRepo metodosCrud;
    
    
    
    /** < - - - - - - - - { Metodos } - - - - - - - - > */
    
    
    // < CREATE - NEW USER >
    public User saveUser(User user) {
        if (user.getIdentification() == null || user.getName()== null ||
        user.getAddress()== null || user.getCellPhone()== null ||
        user.getEmail()== null || user.getPassword()== null || 
        user.getZone()== null || user.getType()== null) {
            return user;
            
        } else {
            List<User> userExist = metodosCrud.getUserByNameOrEmail(user.getName(), user.getEmail());
            if (userExist.isEmpty()) {
                if (user.getId() == null) {
                    return metodosCrud.saveUser(user);
                    
                } else {
                    Optional<User> userExist2 = metodosCrud.getUserById(user.getId());
                    if (userExist2.isEmpty()) {
                        return metodosCrud.saveUser(user);
                        
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
        return metodosCrud.getAll();
    }
    
    
    // <EXISTS - EMAIL>
    
    public boolean getUserByEmail(String email) {
        return metodosCrud.getUserByEmail(email).isPresent();
    }
    
    
    
    
    // <EXISTS - USER>
    public User getUserByEmailAndPassword(String email, String password) {
        Optional<User> user = metodosCrud.getUserByEmailAndPassword(email, password);
        
        if (user.isPresent()) {
            return user.get();
            
        } return new User();
        
    }
    
    
    
    // <UPDATE>
    public User updateUser(User user){
        if(user.getId()!=null){
            Optional<User> userExist = metodosCrud.getUserById(user.getId());
            if(userExist.isPresent()){
                if(user.getIdentification()!=null){
                    userExist.get().setIdentification(user.getIdentification());
                }
                if(user.getName()!=null){
                    userExist.get().setName(user.getName());
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
                return metodosCrud.saveUser(userExist.get());
            }else{
                return user;
            }
        }else{
            return user;
        }
    }
    
    
    // <DELETE>
    public boolean deleteUser(Integer id) {
        Optional<User> user = metodosCrud.getUserById(id);
        if (user.isPresent()) {
            metodosCrud.deleteUserById(id);
            return true;
            
        } return false;
        
    }
    
}


