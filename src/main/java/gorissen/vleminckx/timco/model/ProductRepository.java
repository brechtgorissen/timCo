package gorissen.vleminckx.timco.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
//ProductRepository to implement CRUD queries

public interface ProductRepository extends CrudRepository<Product, Integer> {

    //extension of basic CRUD queries to be able to find products based on product category
    List<Product> findByCategory(String category);

}
