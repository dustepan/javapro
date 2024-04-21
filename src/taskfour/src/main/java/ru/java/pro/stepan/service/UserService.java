package ru.java.pro.stepan.service;

import ru.java.pro.stepan.UserDto.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @author SDudin
 */
public interface UserService {
    void createUserDataBase() throws SQLException;

    void deleteUserDataBase() throws SQLException;

    User getUserFromDataBase();

    List<User> getUsersFromDataBase() throws SQLException;
}
