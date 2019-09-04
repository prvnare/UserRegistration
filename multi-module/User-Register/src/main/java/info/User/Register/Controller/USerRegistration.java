package info.User.Register.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Strings;

import info.User.Register.RestApiConstants;
import info.User.Register.model.User;
import info.User.Register.model.UserRegistrationResource;
import info.User.Register.service.UserService;

@RestController
@RequestMapping("/" + RestApiConstants.REGISTRATIONS_RESOURCE)
public class USerRegistration {

    private UserService userService;

    public USerRegistration(UserService userService) {
	this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserRegistrationResource> registerUser(@RequestBody User userRegistration) {
	System.out.println("Test");
	if (Strings.isNullOrEmpty(userRegistration.getUsername())) {
	    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	if (userService.findUserByUsername(userRegistration.getUsername()) != null) {
	    return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	User newUser = new User(userRegistration.getUsername());
	newUser.setEmail(userRegistration.getEmail());
	userService.save(newUser);
	return new ResponseEntity<>(new UserRegistrationResource(newUser), HttpStatus.CREATED);
    }
}
