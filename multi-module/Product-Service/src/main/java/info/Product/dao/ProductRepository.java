package info.Product.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import info.Product.model.Product;

@Repository
public interface ProductRepository  extends JpaRepository<Product, String>{

}
