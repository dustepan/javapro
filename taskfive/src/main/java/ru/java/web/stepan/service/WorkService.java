package ru.java.web.stepan.service;

import org.springframework.stereotype.Service;
import ru.java.web.stepan.cash.CashDb;
import ru.java.web.stepan.dto.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * @author SDudin
 */
@Service
public class WorkService {
    private final CashDb cashDb;

    public WorkService(CashDb cashDb) {
        this.cashDb = cashDb;
    }

    //получение продукта по id продукта
    public Product getProductById(Long productId) {
        return cashDb.getProductById(productId);
    }

    //получение списка продуктов клиента по id пользователя
    public List<Product> getListProductsByUser(Long userId) throws SQLException {
        return cashDb.getProducts(userId);
    }

}
