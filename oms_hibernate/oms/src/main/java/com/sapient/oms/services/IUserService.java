package com.sapient.oms.services;

import java.util.List;

import com.sapient.oms.entity.User;

public interface IUserService {
    User createUser(User user);

    public List<User> getAllUsers();

    public User getUserById(int id);

}
