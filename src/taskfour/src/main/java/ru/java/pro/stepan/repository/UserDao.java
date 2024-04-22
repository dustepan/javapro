package ru.java.pro.stepan.repository;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.stereotype.Repository;
import ru.java.pro.stepan.UserDto.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author SDudin
 */
@Repository
public class UserDao {
    private final HikariDataSource dataSource;

    public UserDao(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void save() throws SQLException {
        Statement statement = dataSource.getConnection().createStatement();
        statement.execute("INSERT INTO userfortest(userid, username) VALUES(26, '123')");
    }

    public void delete() throws SQLException {
        Statement statement = dataSource.getConnection().createStatement();
        statement.execute("DELETE FROM userfortest WHERE userid = 1");
    }

    public User findById() throws SQLException {
        User user = new User();
        Statement statement = dataSource.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM userfortest WHERE userid = 1");
        while (resultSet.next()) {
            Long id = resultSet.getLong("userid");
            String userName = resultSet.getString("username");
            user.setUserId(id);
            user.setUserName(userName);
        }
        return user;
    }


    public List<User> findAll() throws SQLException {
        List<User> userList = new ArrayList<>();
        Statement statement = dataSource.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM userfortest");
        while (resultSet.next()) {
            Long id = resultSet.getLong("userid");
            String userName = resultSet.getString("username");
            User user = new User(id, userName);
            userList.add(user);
        }
        return userList;
    }
}
