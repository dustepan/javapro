package ru.java.web.stepan.service;


import ru.java.web.stepan.entity.Product;

import java.util.List;

/**
 * @author SDudin
 */
public interface WorkService {
    Product getProductFromDB(Long productId);

    List<Product> getAllProductForUserFromDB(Long userId);
}
