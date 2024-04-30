package ru.java.web.stepan.repository;

import org.springframework.stereotype.Repository;
import ru.java.web.stepan.dto.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * @author SDudin
 */
@Repository
public class ProductRepository {

    private final Connection connection;

    public ProductRepository(Connection connection) {
        this.connection = connection;
    }

    public Map<Long, Product> findAllProducts() throws SQLException {
        HashMap<Long, Product> productHashMap = new HashMap<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM producttest");
        while (resultSet.next()) {
            Long id = resultSet.getLong("productId");
            Product product = resultSet.getObject("product", Product.class);
            productHashMap.put(id, product);
        }
        return productHashMap;
    }
}
