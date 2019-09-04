package info.User.Register.service;

import info.User.Register.model.User;

public interface UserService {
    User findUserByUsername(String username);

    User save(User user);

}
