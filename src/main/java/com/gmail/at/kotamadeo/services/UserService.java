package com.gmail.at.kotamadeo.services;

import com.gmail.at.kotamadeo.models.User;

import java.util.List;

public interface UserService {
    List<User> showAllUsers(int count);

    User getUser(long id);

    void createNewUser(User user);

    void updateUserById(long id, User user);

    void deleteUserById(Long id);
}
