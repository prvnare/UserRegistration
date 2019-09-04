package info.User.Register.model;
public class UserRegistrationResource {
    private String username;
    private String email;
    private String password;

    public String getPassword() {
        return password;
    }

    protected UserRegistrationResource() {
    }

    public UserRegistrationResource(User user) {
        username = user.getUsername();
        password = user.getPassword();
        email = user.getEmail();
    }


    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

}