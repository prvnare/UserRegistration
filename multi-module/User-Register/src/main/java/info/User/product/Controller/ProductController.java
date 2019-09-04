package info.User.product.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.Product.Service.ProductService;
import info.Product.model.Product;
import info.User.Register.RestApiConstants;

@RestController
@RequestMapping("/" + RestApiConstants.PRODUCT_ADD)
public class ProductController {

    private ProductService service;
    
    @Autowired
    public  ProductController(ProductService service) {
	this.service =service;
    }
  
    @GetMapping
    public ResponseEntity<List<Product>> getProducts(){
	return new ResponseEntity<List<Product>>(service.findAll(),HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
	service.save(product);
	return new ResponseEntity<Product>(product, HttpStatus.CREATED);
    }
    
}
