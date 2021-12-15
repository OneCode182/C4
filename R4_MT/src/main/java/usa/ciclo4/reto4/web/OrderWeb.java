/** < - - - - - - - - { G3 - Sergio Silva } - - - - - - - - > */


package usa.ciclo4.reto4.web;

import usa.ciclo4.reto4.models.Order;
import usa.ciclo4.reto4.services.OrderService;


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
    
    /** < - - - - - - - - { Metodos } - - - - - - - - > */
    
    // < SAVE - NEW ORDER >
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order save(@RequestBody Order order) {
        return services.save(order);
    }
    
    // < GET - ALL ORDERS >
    @GetMapping("/all")
    public List<Order> getAll() {
        return services.getAll();
    }
    
    // < GET - ORDER BY ID >
    @GetMapping("/{id}")
    public Order getByID(@PathVariable("id") Integer id) {
        return services.getByID(id);
    }
    
    // < GET - ORDER WHERE USER.ZONE = ZONE >
    @GetMapping("/zona/{zone}")
    public List<Order> getUsersZone(@PathVariable("zone") String zone) {
        return services.getUsersByZone(zone);
    }
    
    
    // < UPDATE >
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order order) {
        return services.update(order);
    }
    
    // < DELETE >
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return services.delete(id);
    }

    // < GET - ORDER WHERE USER.ID = ID >
    @GetMapping("/salesman/{id}")
    public List<Order> getUsersById(@PathVariable("id") Integer id) {
        return services.getUsersById(id);
    }

    // < GET - ORDER WHERE STATE = STATE AND USER.ID = ID >
    @GetMapping("/state/{status}/{id}")
    public List<Order> getByStatusAndByUserId(@PathVariable("status") String status,@PathVariable("id") Integer id) {
        return services.getByStatusAndByUserId(status, id);
    }

    // < GET - ORDER WHERE DATE = DATE AND USER.ID = ID >
    @GetMapping("/date/{date}/{id}")
    public List<Order> getByDateAndByUserId(@PathVariable("date") String date, @PathVariable("id") Integer id) {
        return services.ordersSalesManByDate(date, id);
    }




}

