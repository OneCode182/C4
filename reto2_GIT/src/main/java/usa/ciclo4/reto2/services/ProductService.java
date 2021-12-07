/** < - - - - - - - - { G3 - Sergio Silva } - - - - - - - - > */

package usa.ciclo4.reto2.services;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.ciclo4.reto2.models.Product;
import usa.ciclo4.reto2.models.User;
import usa.ciclo4.reto2.repositories.ProductRepo;



@Service
public class ProductService {
    
    /** < - - - - - - - - { Atributos } - - - - - - - - > */
    @Autowired
    private ProductRepo repository;
    
    
    
    /** < - - - - - - - - { Metodos } - - - - - - - - > */
    
    
    // < CREATE - NEW PRODUCT >
    public Product saveProduct(Product product) {
        if (product.getBrand() == null || product.getProcesor() == null ||
        product.getOs() == null || product.getDescription() == null ||
        product.getMemory() == null || product.getHardDrive() == null || 
        product.getPhotography() == null) {
            return product;
            
        } else {
            Optional<Product> productExists = repository.getById(product.getId());
            if (productExists.isEmpty()) {
                return repository.saveProduct(product);
                
            } else {
                return product;
                
            }

        }
        
    }
    
    // <GET USER BY ID>
    public Product getProductoByID(Integer id) {
        Optional<Product> product = repository.getById(id);
        
        if (product.isPresent()) {
            return product.get();
            
        } return new Product();
        
    }
    
    
    // < READ - ALL PRODUCTS >
    public List<Product> getAll() {
        return repository.getAll();
    }
    
    // <UPDATE>
    public Product updateProduct(Product product){
        if(product.getId() != null){
            Optional<Product> productExists = repository.getById(product.getId());
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
                
                return repository.saveProduct(productExists.get());
                
            }else{
                return product;
            }
        }else{
            return product;
        }
    }
    
    private int getMaxID() {
        List<Product> products = repository.getAll();
        ArrayList<Integer> ids = new ArrayList<Integer>();
        for (Product product : products) {
            ids.add(product.getId());

        } Collections.sort(ids);
        return ids.size() + 1; // length
    }
    
    
    // <READ - ASIGN NEW ID>
    public int getID() {
        int maxID = getMaxID();
        for (int i = 0; i <= maxID; i++) { 
            Optional<Product> exist = repository.getById(i);
            if (exist.isEmpty()) {
                return i;

            }

        } return maxID;

    }
    
    
    // <DELETE>
    public boolean deleteProduct(Integer id) {
        Optional<Product> product = repository.getById(id);
        if (product.isPresent()) {
            repository.deleteProduct(id);
            return true;
            
        } return false;
        
    }
    
}


