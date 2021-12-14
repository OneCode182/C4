/** < - - - - - - - - { G3 - Sergio Silva } - - - - - - - - > */

package usa.ciclo4.reto3.web;



import java.util.List;
import usa.ciclo4.reto3.models.Order;
import usa.ciclo4.reto3.services.OrderService;
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
@RequestMapping("/order")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class OrderWeb {
    
    /** < - - - - - - - - { Atributos } - - - - - - - - > */
    
    @Autowired
    private OrderService service;
    
    /** < - - - - - - - - { Metodos } - - - - - - - - > */
    
    // < POST >
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order save(@RequestBody Order order) {
        return service.save(order);
    }
    
    // < GET - ALL ORDERS >
    @GetMapping("/getAll")
    public List<Order> getAll() {
        return service.getAll();
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
    
    // < GET - ORDER BY ID >
    @GetMapping("/getByID/{id}")
    public Order getByID(@PathVariable("id") Integer id) {
        return service.getByID(id);
    }
    
    // < GET - ORDERS WHERE USER.ZONE = ZONE >
    @GetMapping("/getByUserZone/{zone}")
    public List<Order> getByUsersZone(@PathVariable("zone") String zone) {
        return service.getUsersByZone(zone);
    }
    
    // < GET - ORDER BY STATUS >
    @GetMapping("/getByStatus/{status}")
    public List<Order> getByStatus(@PathVariable("status") String status) {
        return service.getOrderByStatus(status);
    }
    
    // < GET - ORDER BY USER ID >
    @GetMapping("/getByUserId/{id}")
    public List<Order> getByUserId(@PathVariable("id") Integer id) {
        return service.getOrderBySalesmanId(id);
    }
    
    // < GET - ORDER BY PRODUCT ID >
    @GetMapping("/getByProductId/{id}")
    public List<Order> getByProductId(@PathVariable("id") Integer id) {
        return service.getByProductsId(id);
    }
    
    // < UPDATE >
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order order) {
        return service.update(order);
    }
    
    // < DELETE - ORDER BY ID>
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

