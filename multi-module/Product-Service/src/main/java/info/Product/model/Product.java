package info.Product.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product implements Serializable {

    @Id
    private String productId;
    @Column
    private String productName;
    @Column
    private String productPrice;

    public Product() {
    }

    public Product( String productId ,String productName, String productPrice) {
	this.productId = productId;
	this.productName = productName;
	this.productPrice = productPrice;
    }

    public String getProductId() {
	return productId;
    }

    public void setProductId(String productId) {
	this.productId = productId;
    }

    public String getProductName() {
	return productName;
    }

    public void setProductName(String productName) {
	this.productName = productName;
    }

    public String getProductPrice() {
	return productPrice;
    }

    public void setProductPrice(String productPrice) {
	this.productPrice = productPrice;
    }

}
