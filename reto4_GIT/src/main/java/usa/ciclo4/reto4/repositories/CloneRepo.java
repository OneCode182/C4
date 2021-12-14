/** < - - - - - - - - { G3 - Sergio Silva } - - - - - - - - > */


package usa.ciclo4.reto4.repositories;

import usa.ciclo4.reto4.models.Clone;
import usa.ciclo4.reto4.repositories.crud.CloneInterface;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class CloneRepo {
    
    /** < - - - - - - - - { Atributos } - - - - - - - - > */
    @Autowired
    private CloneInterface crud;
    
    
    
    /** < - - - - - - - - { Metodos } - - - - - - - - > */
    
    // <CREATE - UPDATE>
    public Clone save(Clone product) {
        return crud.save(product);
    }
    
    // <READ - ALL>
    public List<Clone> getAll() {
        return (List<Clone>) crud.findAll();
    }
    
    // <READ - ID>
    public Optional<Clone> getByID(Integer id) {
        return crud.findById(id);
    }
    
    // <DELETE>
    public void delete(Integer id) {
        crud.deleteById(id);
    }
    
    
    
}


