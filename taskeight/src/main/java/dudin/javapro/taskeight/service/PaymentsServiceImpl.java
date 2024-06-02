package dudin.javapro.taskeight.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author SDudin
 */
@Service
public class PaymentsServiceImpl implements PaymentsService {
    private final RestTemplate paymentsClient;

    public PaymentsServiceImpl(RestTemplate paymentsClient) {
        this.paymentsClient = paymentsClient;
    }

    @Override
    public Boolean transferMoneyForUser(Long money) {
        return paymentsClient.patchForObject("/payments-for-user", money, Boolean.class);
    }
}
