package info.User.Register.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.User.Register.dao.UserRepository;
import info.User.Register.model.User;

@Service
public class UserServiceImpl  implements UserService{

    @Autowired
    private UserRepository userRepository ;

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }


    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
