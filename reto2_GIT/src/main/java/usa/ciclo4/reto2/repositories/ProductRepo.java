/** < - - - - - - - - { G3 - Sergio Silva } - - - - - - - - > */

package usa.ciclo4.reto2.repositories;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.ciclo4.reto2.models.Product;
import usa.ciclo4.reto2.repositories.crud.ProductInterface;


@Repository
public class ProductRepo {
    
    /** < - - - - - - - - { Atributos } - - - - - - - - > */
    @Autowired
    private ProductInterface crud;
    
    
    
    /** < - - - - - - - - { Metodos } - - - - - - - - > */
    
    // <CREATE - UPDATE>
    public Product saveProduct(Product product) {
        return crud.save(product);
    }
    
    // <READ - ALL>
    public List<Product> getAll() {
        return (List<Product>) crud.findAll();
    }
    
    // <READ - ID>
    public Optional<Product> getById(Integer id) {
        return crud.findById(id);
    }
    
    // <DELETE>
    public void deleteProduct(Integer id) {
        crud.deleteById(id);
    }
    
    
    
}


