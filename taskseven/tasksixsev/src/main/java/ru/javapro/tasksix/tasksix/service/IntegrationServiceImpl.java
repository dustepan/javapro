package ru.javapro.tasksix.tasksix.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.javapro.tasksix.tasksix.dto.Product;
import ru.javapro.tasksix.tasksix.dto.ResponseWithList;

import java.util.List;

/**
 * @author SDudin
 */
@Service
public class IntegrationServiceImpl implements IntegrationService {
    private final RestTemplate operationWithDBClient;

    public IntegrationServiceImpl(RestTemplate operationWithDBClient) {
        this.operationWithDBClient = operationWithDBClient;
    }

    @Override
    public List<Product> getProductList(Long id) {
        ResponseWithList response = operationWithDBClient.getForObject("/getProductsBuUserId?id=" + id
                , ResponseWithList.class);

        if (response == null) {
            return List.of();
        }
        return response.getList();
    }
}
