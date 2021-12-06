/** < - - - - - - - - { G3 - Sergio Silva } - - - - - - - - > */

package usa.ciclo4.reto2.services;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.ciclo4.reto2.models.Clone;
import usa.ciclo4.reto2.repositories.CloneRepo;



@Service
public class CloneService {
    
    /** < - - - - - - - - { Atributos } - - - - - - - - > */
    @Autowired
    private CloneRepo repository;
    
    
    
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
    
    
    // <DELETE>
    public boolean delete(Integer id) {
        Optional<Clone> exists = repository.getByID(id);
        if (exists.isPresent()) {
            repository.delete(id);
            return true;
            
        } return false;
        
    }
    
}


