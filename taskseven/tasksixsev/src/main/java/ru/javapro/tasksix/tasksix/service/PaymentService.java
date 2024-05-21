package ru.javapro.tasksix.tasksix.service;

import ru.javapro.tasksix.tasksix.dto.Product;
import ru.javapro.tasksix.tasksix.dto.RequestDto;

/**
 * @author SDudin
 */
public interface PaymentService {
    Product getResultForOperation(RequestDto requestDto);
}
