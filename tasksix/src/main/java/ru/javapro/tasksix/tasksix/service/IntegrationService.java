package ru.javapro.tasksix.tasksix.service;

import ru.javapro.tasksix.tasksix.dto.Product;

import java.util.List;

/**
 * @author SDudin
 */
public interface IntegrationService {
     List<Product> getProductList(Long id);
}
