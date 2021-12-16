/** < - - - - - - - - { G3 - Sergio Silva } - - - - - - - - > */

package usa.ciclo4.reto2.web;



import java.util.List;
import usa.ciclo4.reto2.models.User;
import usa.ciclo4.reto2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserWeb {
    
    /** < - - - - - - - - { Atributos } - - - - - - - - > */
    
    @Autowired
    private UserService servicios;
    
    /** < - - - - - - - - { Metodos } - - - - - - - - > */
    
    // <SAVE NEW USER>
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody User user) {
        return servicios.saveUser(user);
    }
    
    // <GET ALL USERS>
    @GetMapping("/all")
    public List<User> getUsers() {
        return servicios.getAll();
    }
    
    // <GET EMAIL EXISTS>
    @GetMapping("/emailexist/{email}")
    public boolean emailExists(@PathVariable("email") String email) {
        return servicios.getUserByEmail(email);
    }
    
    // <GET USER EXISTS>
    @GetMapping("/{email}/{password}")
    public User userExists(@PathVariable("email") String email,
    @PathVariable("password") String password) {
        return servicios.getUserByEmailAndPassword(email, password);
    }
    
    // <UPDATE USER>
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User updateUser(@RequestBody User user) {
        return servicios.updateUser(user);
    }
    
    // <DELETE USER>
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteUser(@PathVariable("id") int id) {
        return servicios.deleteUser(id);
    } 
    
}

