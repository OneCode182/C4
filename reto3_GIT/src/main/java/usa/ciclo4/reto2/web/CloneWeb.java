/** < - - - - - - - - { G3 - Sergio Silva } - - - - - - - - > */

package usa.ciclo4.reto2.web;



import java.util.List;
import usa.ciclo4.reto2.models.Clone;
import usa.ciclo4.reto2.services.CloneService;
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
    
    /** < - - - - - - - - { Metodos } - - - - - - - - > */
    
    // < SAVE - NEW CLONE >
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Clone save(@RequestBody Clone product) {
        return services.save(product);
    }
    
    // < GET - ALL CLONES >
    @GetMapping("/all")
    public List<Clone> getAll() {
        return services.getAll();
    }
    
    // < GET - CLONE BY ID >
    @GetMapping("/{id}")
    public Clone getByID(@PathVariable("id") Integer id) {
        return services.getByID(id);
    }
    
    
    // < UPDATE >
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Clone updateProduct(@RequestBody Clone product) {
        return services.update(product);
    }
    
    // < DELETE >
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteProduct(@PathVariable("id") int id) {
        return services.delete(id);
    } 
    
}

