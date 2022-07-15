package com.gmail.at.kotamadeo.dao;

import com.gmail.at.kotamadeo.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional(readOnly = true)
    public List<User> showAllUsers(int count) {
        if (count == 0 || count >= 10) {
            return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
        } else {
            return entityManager.createQuery("SELECT u FROM User u", User.class).setFirstResult(0)
                    .setMaxResults(count).getResultList();
        }
    }

    @Override
    @Transactional(readOnly = true)
    public User getUser(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void createNewUser(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void updateUserById(long id, User user) {
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public void deleteUserById(Long id) {
        entityManager.remove(getUser(id));
    }
}
