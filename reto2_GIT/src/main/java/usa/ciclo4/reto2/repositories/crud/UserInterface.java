/** < - - - - - - - - { G3 - Sergio Silva } - - - - - - - - > */


package usa.ciclo4.reto2.repositories.crud;


import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import usa.ciclo4.reto2.models.User;




public interface UserInterface extends CrudRepository<User, Integer> {
    
    // SEARCH THE COMBINATION OF NAME OR EMAIL
    public List<User> findByNameOrEmail(String name, String email);
    
    // SEARCH IF AN EMAIL IS REGISTERED
    public Optional<User> findByEmail(String email);
    
    // SEARCH THE COMBINATION OF EMAIL AND PASSWORD OF AN USER
    public Optional<User> findByEmailAndPassword(String email, String password);
    
}


