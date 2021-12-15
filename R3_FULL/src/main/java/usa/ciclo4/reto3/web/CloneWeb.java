/** < - - - - - - - - { G3 - Sergio Silva } - - - - - - - - > */

package usa.ciclo4.reto3.web;



import java.util.List;
import usa.ciclo4.reto3.models.Clone;
import usa.ciclo4.reto3.services.CloneService;
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
    private CloneService service;
    
    /** < - - - - - - - - { Metodos } - - - - - - - - > */
    
    // < POST >
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Clone save(@RequestBody Clone product) {
        return service.save(product);
    }
    
    // < GET - ALL CLONES >
    @GetMapping("/getAll")
    public List<Clone> getAll() {
        return service.getAll();
    }
    
    // < GET - CLONE BY ID >
    @GetMapping("/getByID/{id}")
    public Clone getByID(@PathVariable("id") Integer id) {
        return service.getByID(id);
    }
    
    // < GET - AMOUNT ALL >
    @GetMapping("/getAmount")
    public int getAmount() {
        return service.getAmount();
    }
    
    // < GET - ID AUTOINCREMENT >
    @GetMapping("/getNewID")
    public int getID() {
        return service.getID();
    }
    
    // < PUT >
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Clone updateProduct(@RequestBody Clone product) {
        return service.update(product);
    }
    
    // < DELETE - USER BY ID >
    @DeleteMapping("/delete/{id}")
    public boolean deleteProduct(@PathVariable("id") int id) {
        return service.delete(id);
    } 
    
    // < DELETE - ALL >
    @DeleteMapping("/deleteAll")
    public boolean deleteAll() {
        return service.deleteAll();
    } 
    
}


