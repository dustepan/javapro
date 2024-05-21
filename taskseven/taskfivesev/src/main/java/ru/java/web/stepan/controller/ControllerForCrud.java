package ru.java.web.stepan.controller;

import org.springframework.web.bind.annotation.RestController;
import ru.java.web.stepan.api.ControllerForCrudApi;
import ru.java.web.stepan.entity.Product;
import ru.java.web.stepan.service.WorkService;

import java.util.List;

/**
 * @author SDudin
 */
@RestController
public class ControllerForCrud implements ControllerForCrudApi {
    private final WorkService workService;

    public ControllerForCrud(WorkService workService) {
        this.workService = workService;
    }

    @Override
    public Product getProduct(Long id) {
        return workService.getProductFromDB(id);
    }

    @Override
    public List<Product> getProductList(Long id) {
        return workService.getAllProductForUserFromDB(id);
    }


}
