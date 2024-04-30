package ru.java.web.stepan.cash;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import ru.java.web.stepan.dto.Product;
import ru.java.web.stepan.repository.ProductRepository;
import ru.java.web.stepan.repository.UsersRepository;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author SDudin
 */

/**
 * Таблица продуктов будет хранить в себе продуктИд и непосредственно продукты.
 * Сохраняем эти данные в мапе productMap далее отдаем по ключу
 *
 * Таблица юзеров будет хрнаить в себе юзерИд и список продуктИд этого клиента
 * Сохраняем эти данные в виде юзерИд и списка продуктов в мапе userMap
 * далее по юзерИд получем список продуктИд этого клиента и через стрим получаем список самих продуктов из productMap
 */

@Component
public class CashDbImpl implements CashDb {
    private final ProductRepository productRepository;
    private final UsersRepository usersRepository;

    private final Map<Long, Product> productMap = new HashMap<>();
    private final Map<Long, List<Long>> userMap = new HashMap<>();

    public CashDbImpl(ProductRepository productRepository, UsersRepository usersRepository) {
        this.productRepository = productRepository;
        this.usersRepository = usersRepository;
    }

    @Override
    public Product getProductById(Long productId) {
        return productMap.get(productId);
    }

    @Override
    public List<Product> getProducts(Long userId) {
        List<Long> listProductsId = userMap.get(userId);
        return listProductsId.stream()
                .map(productMap::get)
                .toList();
    }

    @PostConstruct
    public void init() throws SQLException {
        Map<Long, Product> productRepositoryAll = productRepository.findAllProducts();
        productMap.putAll(productRepositoryAll);

        Map<Long, List<Long>> userAll = usersRepository.findByUserAll();
        userMap.putAll(userAll);
    }

}
