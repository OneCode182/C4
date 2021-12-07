/** < - - - - - - - - { G3 - Sergio Silva } - - - - - - - - > */

package usa.ciclo4.reto2.web;



import java.util.List;
import usa.ciclo4.reto2.models.Product;
import usa.ciclo4.reto2.services.ProductService;
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
public class ProductWeb {
    
    /** < - - - - - - - - { Atributos } - - - - - - - - > */
    
    @Autowired
    private ProductService service;
    
    /** < - - - - - - - - { Metodos } - - - - - - - - > */
    
    // <SAVE NEW PRODUCT>
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Product saveProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }
    
    // <GET ALL PRODUCTS>
    @GetMapping("/all")
    public List<Product> getProducts() {
        return service.getAll();
    }
    
    // <READ - ASIGN NEW ID>
    @GetMapping("/newid")
    public int getID() {
        return service.getID();
    }
    
    // <READ - ASIGN NEW ID>
    @GetMapping("/{id}")
    public Product getProductByID(@PathVariable("id") Integer id) {
        return service.getProductoByID(id);
    }
    
    
    // <UPDATE USER>
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }
    
    // <DELETE USER>
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteProduct(@PathVariable("id") int id) {
        return service.deleteProduct(id);
    } 
    
}

