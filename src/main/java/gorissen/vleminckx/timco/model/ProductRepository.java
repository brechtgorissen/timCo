package gorissen.vleminckx.timco.model;


//Liesbeth

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    public List<Product> findByCategory(String category);

}
