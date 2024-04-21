package ru.java.pro.stepan.service;

import org.springframework.stereotype.Service;
import ru.java.pro.stepan.UserDto.User;
import ru.java.pro.stepan.repository.UserDao;

import java.sql.SQLException;
import java.util.List;

/**
 * @author SDudin
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;


    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public void createUserDataBase() throws SQLException {
        userDao.save();
    }

    public void deleteUserDataBase() throws SQLException {
        userDao.delete();
    }

    public User getUserFromDataBase() {
        try {
            return userDao.findById();
        } catch (Exception e) {
            throw new RuntimeException("Not found user this id");
        }
    }

    public List<User> getUsersFromDataBase() throws SQLException {
        return userDao.findAll();
    }
}
