package ru.java.web.stepan.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.java.web.stepan.constants.UriConstants;
import ru.java.web.stepan.dto.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * @author SDudin
 */
public interface ControllerForCrudApi {
    @GetMapping(value = UriConstants.GET_PRODUCT)
    Product getProduct(@RequestParam Long id);

    @GetMapping(value = UriConstants.GET_PRODUCTS_LIST)
    List<Product> getProductList(@RequestParam Long id) throws SQLException;
}
