/** < - - - - - - - - { G3 - Sergio Silva } - - - - - - - - > */



package usa.ciclo4.reto3.web;

import usa.ciclo4.reto3.models.User;
import usa.ciclo4.reto3.services.UserService;


import java.util.List;
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
    private UserService services;
    
    /** < - - - - - - - - { Metodos GET } - - - - - - - - > */
    
    // < GET - ALL >
    @GetMapping("/getAll")
    public List<User> getAll() {
        return services.getAll();
    }
    
    // < GET - BY ID >
    @GetMapping("/getById/{id}")
    public User getUserByID(@PathVariable("id") Integer id) {
        return services.getById(id);
    }
    
    // < GET - ID EXISTS >
    @GetMapping("/getIdExists/{id}")
    public boolean getIdExists(@PathVariable("id") Integer id) {
        return services.getIdExists(id);
    }
    
    // < GET - AMOUNT ALL USERS >
    @GetMapping("/getAmount")
    public int getAmount() {
        return services.getAmount();
    }
    
    
    // < GET - EMAIL EXISTS >
    @GetMapping("/getEmailExists/{email}")
    public boolean getEmailExists(@PathVariable("email") String email) {
        return services.getEmailExists(email);
    }
    
    // < GET - BY EMAIL >
    @GetMapping("/getByEmail/{email}")
    public User getByEmail(@PathVariable("email") String email) {
        return services.getUserByEmail(email);
    }
    
    // <GET - BY EMAIL AND PASSWORD>
    @GetMapping("/getByEmailAndPassword/{email}/{password}")
    public User getByEmailAndPassword(@PathVariable("email") String email,
    @PathVariable("password") String password) {
        return services.getUserByEmailAndPassword(email, password);
    }
    
    // < GET - AUTHENTICATE >
    @GetMapping("/getAuthenticate/{email}/{password}")
    public boolean getAuthenticate(@PathVariable("email") String email,
    @PathVariable("password") String password) {
        return services.getEmailAndPasswordExists(email, password);
    }
    
    /** < - - - - - - - - { Metodos POST } - - - - - - - - > */
    
    // < POST - NEW USER >
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user) {
        return services.save(user);
    }
    
    
    /** < - - - - - - - - { Metodos PUT } - - - - - - - - > */
    
    // < UPDATE - USER >
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user) {
        return services.update(user);
    }
    
    
    /** < - - - - - - - - { Metodos DELETE } - - - - - - - - > */
    
    // < DELETE - BY ID >
    @DeleteMapping("/deleteById/{id}")
    public boolean deleteById(@PathVariable("id") int id) {
        return services.deleteById(id);
    } 
    
    // < DELETE - BY USER >
    @DeleteMapping("/deleteByUser")
    public boolean deleteByUser(@RequestBody User user) {
        return services.deleteByUser(user);
    } 
    
    // < DELETE - ALL >
    @DeleteMapping("/deleteAll")
    public boolean deleteAll() {
        return services.deleteAll();
    } 
    
}

