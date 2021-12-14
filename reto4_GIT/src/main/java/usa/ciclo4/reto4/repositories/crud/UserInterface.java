/** < - - - - - - - - { G3 - Sergio Silva } - - - - - - - - > */


package usa.ciclo4.reto4.repositories.crud;

import usa.ciclo4.reto4.models.User;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserInterface extends MongoRepository<User, Integer> {
    
    // SEARCH THE COMBINATION OF NAME OR EMAIL
    public List<User> findByNameOrEmail(String name, String email);
    
    // SEARCH IF AN EMAIL IS REGISTERED
    public Optional<User> findByEmail(String email);
    
    // SEARCH THE COMBINATION OF EMAIL AND PASSWORD OF AN USER
    public Optional<User> findByEmailAndPassword(String email, String password);
    
}


