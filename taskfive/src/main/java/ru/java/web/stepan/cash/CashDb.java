package ru.java.web.stepan.cash;

import ru.java.web.stepan.dto.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * @author SDudin
 */
public interface CashDb {
    Product getProductById(Long productId);

    List<Product> getProducts(Long userId) throws SQLException;

}
