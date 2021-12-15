/** < - - - - - - - - { G3 - Sergio Silva } - - - - - - - - > */

package usa.ciclo4.reto3.web;



import java.util.List;
import usa.ciclo4.reto3.models.User;
import usa.ciclo4.reto3.services.UserService;
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
    private UserService service;
    
    /** < - - - - - - - - { Metodos } - - - - - - - - > */
    
    // < POST >
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody User user) {
        return service.save(user);
    }
    
    // < GET - ALL >
    @GetMapping("/getAll")
    public List<User> getUsers() {
        return service.getAll();
    }
    
    // < GET - USER BY ID >
    @GetMapping("/getByID/{id}")
    public User getUserByID(@PathVariable("id") Integer id) {
        return service.getUserByID(id);
    }
    
    // < GET - AMOUNT >
    @GetMapping("/getAmount")
    public int getAmount() {
        return service.getAmount();
    }
    
    // < GET - ID AUTOINCREMENT >
    @GetMapping("/getNewID")
    public int getID() {
        return service.getID();
    }
    
    // < GET - EMAIL EXISTS >
    @GetMapping("/getByEmail/{email}")
    public User getByEmail(@PathVariable("email") String email) {
        return service.getUserJsonByEmail(email);
    }
    
    
    // < GET - EMAIL EXISTS >
    @GetMapping("/emailExists/{email}")
    public boolean emailExists(@PathVariable("email") String email) {
        return service.getUserByEmail(email);
    }
    
    // < GET - USER EXISTS >
    @GetMapping("/authenticate/{email}/{password}")
    public boolean userExists(@PathVariable("email") String email,
    @PathVariable("password") String password) {
        return service.getUserByEmailAndPassword(email, password);
    }
    
    // < PUT >
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user) {
        return service.update(user);
    }
    
    // < DELETE - USER BY ID >
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int id) {
        return service.delete(id);
    } 
    
    // < DELETE - ALL >
    @DeleteMapping("/deleteAll")
    public boolean deleteAll() {
        return service.deleteAll();
    } 
    
}

