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
    private CloneInterface crudRepo;
    
    
    
    /** < - - - - - - - - { Metodos } - - - - - - - - > */
    
    // <CREATE - UPDATE>
    public Clone save(Clone product) {
        return crudRepo.save(product);
    }
    
    // <READ - ALL>
    public List<Clone> getAll() {
        return (List<Clone>) crudRepo.findAll();
    }
    
    // <READ - AMOUNT USERS>
    public int getAmount() {
        return (int) crudRepo.count();
    }
    
    // <READ - ID>
    public Optional<Clone> getByID(Integer id) {
        return crudRepo.findById(id);
    }
    
    // < DELETE - BY USER OBJECT >
    public void deleteByUser(Clone clone) {
        crudRepo.delete(clone);
    }
    
    // < DELETE - BY ID >
    public void deleteById(Integer id) {
        crudRepo.deleteById(id);
    }
    
    // < DELETE - ALL >
    public void deleteAll() {
        crudRepo.deleteAll();
    }
    
    
    
}


