/** < - - - - - - - - { G3 - Sergio Silva } - - - - - - - - > */


package usa.ciclo4.reto3.web;

import usa.ciclo4.reto3.models.Order;
import usa.ciclo4.reto3.services.OrderService;


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
@RequestMapping("/order")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class OrderWeb {
    
    /** < - - - - - - - - { Atributos } - - - - - - - - > */
    
    @Autowired
    private OrderService services;
    
    /** < - - - - - - - - { Metodos GET } - - - - - - - - > */
    
    
    // < GET - ALL >
    @GetMapping("/getAll")
    public List<Order> getAll() {
        return services.getAll();
    }
    
    // < GET - BY ID >
    @GetMapping("/getById/{id}")
    public Order getById(@PathVariable("id") Integer id) {
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
    
    // < GET - ORDER WHERE USER.ZONE = ZONE >
    @GetMapping("/getByUserZone/{zone}")
    public List<Order> getByUserZone(@PathVariable("zone") String zone) {
        return services.getUsersByZone(zone);
    }
    

    // < GET - BY USER ID >
    @GetMapping("/getByUserId/{id}")
    public List<Order> getByUserId(@PathVariable("id") Integer id) {
        return services.getUsersById(id);
    }

    // < GET - BY STATUS AND USER ID >
    @GetMapping("/getByStatusAndUserId/{status}/{id}")
    public List<Order> getByStatusAndUserId(@PathVariable("status") String status,@PathVariable("id") Integer id) {
        return services.getByStatusAndByUserId(status, id);
    }
    
    // < GET - BY STATUS >
    @GetMapping("/getByStatus/{status}")
    public List<Order> getByStatus(@PathVariable("status") String status) {
        return services.getOrderByStatus(status);
    }

    // < GET - BY DATE AND USER ID >
    @GetMapping("/getByDateAndUserId/{date}/{id}")
    public List<Order> getByDateAndUserId(@PathVariable("date") String date, @PathVariable("id") Integer id) {
        return services.ordersSalesManByDate(date, id);
    }
    
    // < GET - BY DATE >
    @GetMapping("/getByDate/{date}")
    public List<Order> getByDate(@PathVariable("date") String date) {
        return services.getByDate(date);
    }
    
    /** < - - - - - - - - { Metodos POST } - - - - - - - - > */
    
    // < POST - NEW USER >
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Order save(@RequestBody Order order) {
        return services.save(order);
    }
    
    
    /** < - - - - - - - - { Metodos PUT } - - - - - - - - > */
    
    // < UPDATE - ORDER >
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order order) {
        return services.update(order);
    }
    
    
    
    
    
    /** < - - - - - - - - { Metodos DELETE } - - - - - - - - > */
    
    // < DELETE - BY ID >
    @DeleteMapping("/deleteById/{id}")
    public boolean deleteById(@PathVariable("id") int id) {
        return services.deleteById(id);
    } 
    
    // < DELETE - BY ORDER >
    @DeleteMapping("/deleteByOrder")
    public boolean deleteByOrder(@RequestBody Order order) {
        return services.deleteByOrder(order);
    } 
    
    // < DELETE - ALL >
    @DeleteMapping("/deleteAll")
    public boolean deleteAll() {
        return services.deleteAll();
    } 




}

