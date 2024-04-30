package ru.java.web.stepan.repository;

import org.springframework.stereotype.Repository;
import ru.java.web.stepan.dto.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author SDudin
 */
@Repository
public class UsersRepository {
    private final Connection connection;

    public UsersRepository(Connection connection) {
        this.connection = connection;
    }

    public Map<Long,List<Long>> findByUserAll() throws SQLException {
        List<Long> productsForUser = new ArrayList<>();
        HashMap<Long, List<Long>> map = new HashMap<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM usertest");
        while (resultSet.next()) {
            Long userId = resultSet.getLong("userId");
            Long product = resultSet.getLong("product");
            productsForUser.add(product);
            map.put(userId, productsForUser);
        }
        return map;
    }
}
