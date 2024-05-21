package ru.java.web.stepan.service;

import org.springframework.stereotype.Service;
import ru.java.web.stepan.entity.Product;
import ru.java.web.stepan.repository.ProductRepository;


import java.util.List;

/**
 * @author SDudin
 */
@Service
public class WorkServiceImpl implements WorkService {
    private final ProductRepository productRepository;

    public WorkServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getProductFromDB(Long productId) {
        return productRepository.findProductByProductId(productId);
    }

    @Override
    public List<Product> getAllProductForUserFromDB(Long userId) {
        return productRepository.findProductsByUserId(userId);
    }
}
