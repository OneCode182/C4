/** < - - - - - - - - { G3 - Sergio Silva } - - - - - - - - > */

package usa.ciclo4.reto2.repositories;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.ciclo4.reto2.models.User;
import usa.ciclo4.reto2.repositories.crud.UserInterface;


@Repository
public class UserRepo {
    
    /** < - - - - - - - - { Atributos } - - - - - - - - > */
    @Autowired
    private UserInterface crud;
    
    
    
    /** < - - - - - - - - { Metodos } - - - - - - - - > */
    
    // <CREATE - UPDATE>
    public User saveUser(User user) {
        return crud.save(user);
    }
    
    // <READ - ALL>
    public List<User> getAll() {
        return (List<User>) crud.findAll();
    }
    
    // <READ - AMOUNT USERS>
    public int getAmount() {
        return (int) crud.count();
    }
    
    // <READ - ASIGN NEW ID>
    public List<User> getID() {
        return getAll();
    }
    
    // <USER BY ID>
    public Optional<User> getUserById(Integer id) {
        return crud.findById(id);
    }
    
    // <USER BY EMAIL>
    public Optional<User> getUserByEmail(String email) {
        return crud.findByEmail(email);
    }
    
    // <USER EMAIL AND PASSWORD>
    public Optional<User> getUserByEmailAndPassword(String email, String password) {
        return crud.findByEmailAndPassword(email, password);
    }
    
    // <USER EMAIL OR PASSWORD>
    public List<User> getUserByNameOrEmail(String name, String email) {
        return crud.findByNameOrEmail(name, email);
    }
    
    // <DELETE>
    public void deleteUser(User user) {
        crud.delete(user);
    }
    
    public void deleteUserById(Integer id) {
        crud.deleteById(id);
    }
    
    
    
}


