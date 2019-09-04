package info.Product.Service;

import java.util.List;
import java.util.Optional;

import info.Product.model.Product;

public interface ProductService {
    
    List<Product> findAll();

    Product save(Product product);
    
    Optional <Product> findProduct(String Id);

}
