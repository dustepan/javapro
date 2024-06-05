package dudin.javapro.taskeight.controller;

import dudin.javapro.taskeight.constans.UriConstans;
import dudin.javapro.taskeight.dto.TransferRequestBody;
import dudin.javapro.taskeight.exception.TransferException;
import dudin.javapro.taskeight.service.TransferMoneyService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author SDudin
 */
@RestController
public class TransferMoneyController {
    @Value("sbp-limits")
    private BigDecimal limits;
    private final TransferMoneyService transferMoneyService;

    public TransferMoneyController(TransferMoneyService transferMoneyService) {
        this.transferMoneyService = transferMoneyService;
    }

    @PostMapping(value = UriConstans.TRANSFER_MONEY_SBP)
    public void transferMoneySbp(@RequestBody TransferRequestBody transferRequestBody) {
        if (transferRequestBody.getUserId() > 100 || transferRequestBody.getUserId() < 1) {
            throw new TransferException("Некорректный userId, принимаемые значения id 1-100");
        }
        if (transferRequestBody.getSbpTransfer().compareTo(limits) > 0) {
            throw new TransferException("Перевод невозможен из за ограничений по лимиту");
        }
        transferMoneyService.doTransferMoney(transferRequestBody);
    }
}
