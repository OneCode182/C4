/** < - - - - - - - - { G3 - Sergio Silva } - - - - - - - - > */

package usa.ciclo4.reto3.services;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.ciclo4.reto3.models.Clone;
import usa.ciclo4.reto3.models.Order;
import usa.ciclo4.reto3.repositories.CloneRepo;
import usa.ciclo4.reto3.repositories.OrderRepo;



@Service
public class CloneService {
    
    /** < - - - - - - - - { Atributos } - - - - - - - - > */
    @Autowired
    private CloneRepo repository;
    
    @Autowired
    private OrderService orderService;
    
    @Autowired
    private OrderRepo orderRepo;
    
    
    
    /** < - - - - - - - - { Metodos } - - - - - - - - > */
    
    
    // < CREATE - NEW PRODUCT >
    public Clone save(Clone product) {
        if (product.getBrand() == null || product.getProcesor() == null ||
        product.getOs() == null || product.getDescription() == null ||
        product.getMemory() == null || product.getHardDrive() == null || 
        product.getPhotography() == null) {
            return product;
            
        } else {
            Optional<Clone> productExists = repository.getByID(product.getId());
            if (productExists.isEmpty()) {
                return repository.save(product);
                
            } return product;
            
        }
        
    }
    
    
    // < READ - ALL PRODUCTS >
    public List<Clone> getAll() {
        return repository.getAll();
    }
    
    // < GET - AMOUNT >
    public int getAmount() {
        return repository.getAmount();
    }
    
    // < ALGORITHM - GET MAX ID >
    private int getMaxID() {
        if (getAmount() == 0) {
            return 1;
            
        } else {
            List<Clone> clones = repository.getAll();
            ArrayList<Integer> ids = new ArrayList<>();
            
            for (Clone clone : clones) {
                ids.add(clone.getId());

            } Collections.sort(ids);
            
            return ids.get(ids.size() - 1) + 1;
            
        }
        
    }
    
    // < GET - ASIGN NEW ID >
    public int getID() {
        int maxID = getMaxID();
        if (maxID == 1) {
            return maxID;
                   
        } else {
            for (int i = 1; i <= maxID; i++) { 
                Optional<Clone> exist = repository.getByID(i);
                if (exist.isEmpty()) {
                    return i;

                }

            } return 0;
            
        }
        
    }
    
    // < READ - BY ID >
    public Clone getByID(Integer id) {
        Optional<Clone> exists = repository.getByID(id);
        if (exists.isPresent()) {
            return exists.get();
            
        } return new Clone();
    }
    
    // <UPDATE>
    public Clone update(Clone product){
        if(product.getId() != null){
            Optional<Clone> productExists = repository.getByID(product.getId());
            if(productExists.isPresent()){
                if(product.getBrand() != null){
                    productExists.get().setBrand(product.getBrand());
                }
                if(product.getProcesor() != null){
                    productExists.get().setProcesor(product.getProcesor());
                }
                if(product.getOs() != null){
                    productExists.get().setOs(product.getOs());
                }
                if(product.getDescription() != null){
                    productExists.get().setDescription(product.getDescription());
                }
                if(product.getMemory() != null){
                    productExists.get().setMemory(product.getMemory());
                }
                if(product.getHardDrive() != null){
                    productExists.get().setHardDrive(product.getHardDrive());
                }
                if(true){
                    productExists.get().setAvailability(product.getAvailability());
                }
                if(true){
                    productExists.get().setPrice(product.getPrice());
                }
                if(true){
                    productExists.get().setQuantity(product.getQuantity());
                }
                if(product.getPhotography() != null){
                    productExists.get().setPhotography(product.getPhotography());
                }
                
                return repository.save(productExists.get());
                
            } return product;
            
        } return product;
        
    }
    
    private ArrayList<Integer> getCloneIDS() {
        List<Clone> clones = repository.getAll();
        ArrayList<Integer> ids = new ArrayList<>();

        for (Clone clone : clones) {
            ids.add(clone.getId());

        } return ids;
        
    }
    
    
    // < DELETE - USER BY ID>
    public boolean delete(Integer id) {
        Optional<Clone> exists = repository.getByID(id);
        if (exists.isPresent()) {
            
            
            List<Order> orderByClone = orderService.getByProductsId(id);
            Clone clone = getByID(id);
            
            for (Order order : orderByClone) {
                Map<String, Clone> clones = order.getProducts();
                
                if (clones.size() == 1) {
                    orderRepo.deleteByID(order.getId());
                    
                } else {
                    clones.remove(clone.getId().toString(), clone);

                    order.setProducts(clones);
                    orderRepo.deleteByID(order.getId());
                    orderRepo.save(order);
                
                }
                
            }
            
            repository.delete(id);
            
            return true;
            
        } return false;
        
    }
    
    // < DELETE - ALL >
    public boolean deleteAll() {
        try {
            orderRepo.deleteAll();
            repository.deleteAll();
            
            return true;
            
        } catch (Exception e) {
            return false;
            
        }
        
    }
    
}


