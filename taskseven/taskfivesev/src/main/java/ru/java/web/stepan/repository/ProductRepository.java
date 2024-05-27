package ru.java.web.stepan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.java.web.stepan.entity.Product;

import java.util.List;

/**
 * @author SDudin
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findProductByProductId(Long productId);

    List<Product> findProductsByUserId(Long userId);
}
