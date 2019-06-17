package service;

import Entity.User;

import java.util.List;

public interface UserServiceInterface {
    public void addUser(User user);

    public void removeUser(int id);

    public User getUserById(int id);

    public List<User> userList();
}
