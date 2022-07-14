package com.gmail.at.kotamadeo.services;

import com.gmail.at.kotamadeo.dao.UserDAO;
import com.gmail.at.kotamadeo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @Override
    public List<User> showAllUsers(int count) {
        return userDAO.showAllUsers(count);
    }

    @Override
    public User getUser(long id) {
        return userDAO.getUser(id);
    }

    @Override
    public void createNewUser(User user) {
        userDAO.createNewUser(user);
    }

    @Override
    public void updateUserById(long id, User user) {
        userDAO.updateUserById(id, user);
    }

    @Override
    public void deleteUserById(Long id) {
        userDAO.deleteUserById(id);
    }
}
