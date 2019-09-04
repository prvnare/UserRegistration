package info.Product.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.Product.dao.ProductRepository;
import info.Product.model.Product;

@Service
public class ProductServiceImpl  implements ProductService{
    
    private ProductRepository repository;
    
    public  ProductServiceImpl() {
    }
    
    @Autowired
    public ProductServiceImpl(ProductRepository repository) {
	this.repository =repository;
	System.out.println("Test");
	repository.save(new Product("1", "PlanA","$12"));
	repository.save(new Product("2", "PlanB","$22"));
	repository.save(new Product("3", "PlanC","$12"));
    }

    @Override
    public List<Product> findAll() {
	return repository.findAll();
    }

    @Override
    public Product save(Product product) {
	return repository.save(product);
    }

    @Override
    public Optional<Product> findProduct(String id) {
	return repository.findById(id);
    }

}
