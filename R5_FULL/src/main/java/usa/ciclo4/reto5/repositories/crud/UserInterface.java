/** < - - - - - - - - { G3 - Sergio Silva } - - - - - - - - > */


package usa.ciclo4.reto5.repositories.crud;

import usa.ciclo4.reto5.models.User;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserInterface extends MongoRepository<User, Integer> {
    
    // < GET - BY NAME OR EMAIL >
    public List<User> findByNameOrEmail(String name, String email);
    
    // < GET - BY EMAIL >
    public Optional<User> findByEmail(String email);
    
    // < GET - BY NAME AND EMAIL >
    public Optional<User> findByEmailAndPassword(String email, String password);
    
    // < GET - BY MONTH BIRTHDAY
    public List <User> findByMonthBirthtDay (String birthday);
    
}


