package com.gmail.at.kotamadeo.dao;

import com.gmail.at.kotamadeo.models.User;

import java.util.List;

public interface UserDAO {
    List<User> showAllUsers(int count);

    User getUser(long id);

    void createNewUser(User user);

    void updateUserById(long id, User user);

    void deleteUserById(Long id);

}
