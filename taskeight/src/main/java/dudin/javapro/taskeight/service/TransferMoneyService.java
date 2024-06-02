package dudin.javapro.taskeight.service;

import dudin.javapro.taskeight.dto.TransferRequestBody;

/**
 * @author SDudin
 */
public interface TransferMoneyService {
    void doTransferMoney(TransferRequestBody transferRequestBody);
}
