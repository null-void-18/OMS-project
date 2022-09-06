package com.sapient.oms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.oms.entity.User;
import com.sapient.oms.notification.EmailTemplate;
import com.sapient.oms.repository.UserRepository;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;
    EmailTemplate emailTemplate = new EmailTemplate();

    @Override
    @Transactional(rollbackFor = Exception.class)
    public User createUser(User user) {
        User savedUser = userRepository.save(user);
        emailTemplate.mailUserOnCreation(savedUser);
        return savedUser;

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public User getUserById(int id) {
        User user = userRepository.findById(id).get();
        return user;
    }

}
