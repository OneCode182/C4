/** < - - - - - - - - { G3 - Sergio Silva } - - - - - - - - > */

package usa.ciclo4.reto3.repositories;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.ciclo4.reto3.models.Clone;
import usa.ciclo4.reto3.repositories.crud.CloneInterface;


@Repository
public class CloneRepo {
    
    /** < - - - - - - - - { Atributos } - - - - - - - - > */
    @Autowired
    private CloneInterface crud;
    
    
    
    /** < - - - - - - - - { Metodos } - - - - - - - - > */
    
    // < POST - PUT >
    public Clone save(Clone product) {
        return crud.save(product);
    }
    
    // < GET - ALL >
    public List<Clone> getAll() {
        return (List<Clone>) crud.findAll();
    }
    
    // < GET - AMOUNT >
    public int getAmount() {
        return (int) crud.count();
    }
    
    // < GET - BY ID >
    public Optional<Clone> getByID(Integer id) {
        return crud.findById(id);
    }
    
    // < DELETE - BY ID >
    public void delete(Integer id) {
        crud.deleteById(id);
    }
    
    // < DELETE - ALL >
    public void deleteAll() {
        crud.deleteAll();
    }
    
    
    
}


