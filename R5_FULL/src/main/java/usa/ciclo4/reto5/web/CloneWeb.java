/** < - - - - - - - - { G3 - Sergio Silva } - - - - - - - - > */

package usa.ciclo4.reto5.web;

import usa.ciclo4.reto5.models.Clone;
import usa.ciclo4.reto5.services.CloneService;



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
@RequestMapping("/clone")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CloneWeb {
    
    /** < - - - - - - - - { Atributos } - - - - - - - - > */
    
    @Autowired
    private CloneService services;
    
    /** < - - - - - - - - { Metodos GET } - - - - - - - - > */
    
    // < GET - ALL >
    @GetMapping("/getAll")
    public List<Clone> getAll() {
        return services.getAll();
    }
    
    // < GET - BY ID >
    @GetMapping("/getById/{id}")
    public Clone getUserByID(@PathVariable("id") Integer id) {
        return services.getByID(id);
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
    
    // < GET - BY PRICE >
    @GetMapping("/getByPrice/{price}")
    public List<Clone> findByPrice(@PathVariable("price") double price) {
        return services.findByPrice(price);
    }
    
    // < GET - BY DESCRIPTION >
    @GetMapping("/getByDescription/{description}")
    public List<Clone> findByDescription(@PathVariable("description") String description) {
        return services.findByDescription(description);
    }  
    
    
    /** < - - - - - - - - { Metodos POST } - - - - - - - - > */
    
    // < POST - NEW USER >
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Clone save(@RequestBody Clone clone) {
        return services.save(clone);
    }
    
    
    /** < - - - - - - - - { Metodos PUT } - - - - - - - - > */
    
    // < UPDATE - ORDER >
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Clone update(@RequestBody Clone clone) {
        return services.update(clone);
    }
    
    
    
    
    /** < - - - - - - - - { Metodos DELETE } - - - - - - - - > */
    
    // < DELETE - BY ID >
    @DeleteMapping("/deleteById/{id}")
    public boolean deleteById(@PathVariable("id") int id) {
        return services.deleteById(id);
    } 
    
    // < DELETE - BY ORDER >
    @DeleteMapping("/deleteByClone")
    public boolean deleteByClone(@RequestBody Clone clone) {
        return services.deleteByClone(clone);
    } 
    
    // < DELETE - ALL >
    @DeleteMapping("/deleteAll")
    public boolean deleteAll() {
        return services.deleteAll();
    } 
    
}

