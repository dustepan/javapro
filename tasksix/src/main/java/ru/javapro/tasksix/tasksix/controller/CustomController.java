package ru.javapro.tasksix.tasksix.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.javapro.tasksix.tasksix.dto.Product;
import ru.javapro.tasksix.tasksix.dto.RequestDto;
import ru.javapro.tasksix.tasksix.service.PaymentService;


/**
 * @author SDudin
 */
@RestController
public class CustomController {
    private final PaymentService paymentService;

    public CustomController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping(value = "/payment")
    public Product getProductPaymentService(@RequestBody RequestDto requestDto) {
        return paymentService.getResultForOperation(requestDto);
    }
}
