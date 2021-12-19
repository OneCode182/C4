/** < - - - - - - - - { G3 - Sergio Silva } - - - - - - - - > */


package usa.ciclo4.reto3.repositories;

import usa.ciclo4.reto3.models.User;
import usa.ciclo4.reto3.repositories.crud.UserInterface;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepo {
    
    /** < - - - - - - - - { Atributos } - - - - - - - - > */
    @Autowired
    private UserInterface crudRepo;
    
    
    
    /** < - - - - - - - - { Metodos } - - - - - - - - > */
    
    // <CREATE - UPDATE>
    public User save(User user) {
        return crudRepo.save(user);
    }
    
    // <READ - ALL>
    public List<User> getAll() {
        return (List<User>) crudRepo.findAll();
    }
    
    // <READ - AMOUNT USERS>
    public int getAmount() {
        return (int) crudRepo.count();
    }
    
    // <USER BY ID>
    public Optional<User> getById(Integer id) {
        return crudRepo.findById(id);
    }
    
    
    
    // <USER BY EMAIL>
    public Optional<User> getByEmail(String email) {
        return crudRepo.findByEmail(email);
    }
    
    
    // <USER EMAIL AND PASSWORD>
    public Optional<User> getByEmailAndPassword(String email, String password) {
        return crudRepo.findByEmailAndPassword(email, password);
    }
    
    // <USER EMAIL OR PASSWORD>
    public List<User> getByNameOrEmail(String name, String email) {
        return crudRepo.findByNameOrEmail(name, email);
    }
    
    
    
    // < DELETE - BY USER OBJECT >
    public void deleteByUser(User user) {
        crudRepo.delete(user);
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


