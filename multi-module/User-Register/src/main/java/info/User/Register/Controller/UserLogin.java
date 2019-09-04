package info.User.Register.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.Product.Service.ProductService;
import info.Product.model.Product;
import info.User.Register.RestApiConstants;
import info.User.Register.model.User;
import info.User.Register.service.UserService;

@RestController
@RequestMapping("/" + RestApiConstants.LOGIN_USER_RESOURCE)
public class UserLogin {

    private UserService userService;
    private ProductService productService;

    @Autowired
    public UserLogin(UserService userService,ProductService productService) {
	this.userService = userService;
	this.productService =productService;
    }

    @PostMapping(value = "{username}")
    public ResponseEntity<List<Product>> loginUser(@PathVariable String username) {
	User user = userService.findUserByUsername(username);
	if (user == null) {
	    return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	List<Product> product = productService.findAll();
	userService.save(user);
	List<Product> products = productService.findAll();
	return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }
}
