package service;

import Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
 class UserService implements UserServiceInterface {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        this.userRepository.save(user);
    }

    @Override
    @Transactional
    public void removeUser(int id) {
        this.userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return this.userRepository.getOne(id);
    }

    @Override
    @Transactional
    public List<User> userList() {
        return this.userRepository.findAll();
    }
}
