/** < - - - - - - - - { G3 - Sergio Silva } - - - - - - - - > */

package usa.ciclo4.reto3.repositories;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.ciclo4.reto3.models.User;
import usa.ciclo4.reto3.repositories.crud.UserInterface;


@Repository
public class UserRepo {
    
    /** < - - - - - - - - { Atributos } - - - - - - - - > */
    @Autowired
    private UserInterface crud;
    
    
    
    /** < - - - - - - - - { Metodos } - - - - - - - - > */
    
    // < POST - PUT >
    public User saveUser(User user) {
        return crud.save(user);
    }
    
    // < GET - ALL >
    public List<User> getAll() {
        return (List<User>) crud.findAll();
    }
    
    // < GET - AMOUNT >
    public int getAmount() {
        return (int) crud.count();
    }
    
    // < GET - USER BY ID >
    public Optional<User> getUserById(Integer id) {
        return crud.findById(id);
    }
    
    // < GET - USER BY EMAIL>
    public Optional<User> getUserByEmail(String email) {
        return crud.findByEmail(email);
    }
    
    // < GET - USER BY EMAIL AND PASSWORD>
    public Optional<User> getUserByEmailAndPassword(String email, String password) {
        return crud.findByEmailAndPassword(email, password);
    }
    
    // < GET - USER BY EMAIL OR PASSWORD>
    public List<User> getUserByNameOrEmail(String name, String email) {
        return crud.findByNameOrEmail(name, email);
    }
    
    // < DELETE - ALL >
    public void deleteAll() {
        crud.deleteAll();
    }
    
    // < DELETE - USER BY ID >
    public void deleteById(Integer id) {
        crud.deleteById(id);
    }
    
    
    
}


