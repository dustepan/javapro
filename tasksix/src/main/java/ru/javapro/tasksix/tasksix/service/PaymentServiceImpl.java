package ru.javapro.tasksix.tasksix.service;

import org.springframework.stereotype.Service;
import ru.javapro.tasksix.tasksix.dto.Product;
import ru.javapro.tasksix.tasksix.dto.RequestDto;
import ru.javapro.tasksix.tasksix.exception.CustomException;

import java.util.List;

/**
 * @author SDudin
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    private final IntegrationService integrationService;

    public PaymentServiceImpl(IntegrationService integrationService) {
        this.integrationService = integrationService;
    }

    @Override
    public Product getResultForOperation(RequestDto requestDto) {
        List<Product> productList = integrationService.getProductList(requestDto.getId());
        if (productList.isEmpty()) {
            throw new CustomException("Список продуктов пуст");
        }
        Product productAnswer = productList.stream()
                .filter(pr -> pr.getProductType().name().equals(requestDto.getProduct()))
                .findFirst()
                .orElseThrow(() -> new CustomException("Что-то пошло не так"));

        if (requestDto.getBalance() <= Integer.parseInt(productAnswer.getBalance())) {
            productAnswer.setResultOperation(Boolean.TRUE);
            return productAnswer;
        }
        return new Product(Boolean.FALSE);
    }
}
