package dudin.javapro.taskeight.service;

import dudin.javapro.taskeight.dto.TransferRequestBody;
import dudin.javapro.taskeight.entity.UserEntity;
import dudin.javapro.taskeight.exception.TransferException;
import dudin.javapro.taskeight.repository.TransferSpbRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author SDudin
 */
@Service
public class TransferMoneySbpServiceImpl implements TransferMoneyService {
    @Value("sbp-limits")
    private Long limits;

    private final TransferSpbRepository transferSpbRepository;
    private final PaymentsService paymentsService;

    public TransferMoneySbpServiceImpl(TransferSpbRepository transferSpbRepository, PaymentsService paymentsService) {
        this.transferSpbRepository = transferSpbRepository;
        this.paymentsService = paymentsService;
    }

    @Override
    public void doTransferMoney(TransferRequestBody transferRequestBody) {
        Set<Long> allUsers = transferSpbRepository.findAllUserId();
        if (allUsers.add(transferRequestBody.getUserId())) {
            saveNewUserAndUpdateLimitsSbp(transferRequestBody);
        } else {
            updateLimitsSbpForExistingUser(transferRequestBody);
        }
    }

    private void updateLimitsSbpForExistingUser(TransferRequestBody transferRequestBody) {
        UserEntity repositoryUser = transferSpbRepository.getUser(transferRequestBody.getUserId());
        if (repositoryUser.getSbpLimits() >= transferRequestBody.getSbpTransfer()) {
            Boolean transferMoneyForUser = paymentsService.transferMoneyForUser(transferRequestBody.getSbpTransfer());
            if (transferMoneyForUser) {
                Long newLimit = repositoryUser.getSbpLimits() - transferRequestBody.getSbpTransfer();
                transferSpbRepository.updateSbpLimits(transferRequestBody.getUserId(), newLimit);
            }
        } else {
            throw new TransferException("Лимит превышен");
        }
    }

    private void saveNewUserAndUpdateLimitsSbp(TransferRequestBody transferRequestBody) {
        transferSpbRepository.saveUser(new UserEntity(transferRequestBody.getUserId(), transferRequestBody.getUserName(), limits));
        Boolean transferMoneyForUser = paymentsService.transferMoneyForUser(transferRequestBody.getSbpTransfer());
        if (transferMoneyForUser) {
            Long newLimit = limits - transferRequestBody.getSbpTransfer();
            transferSpbRepository.updateSbpLimits(transferRequestBody.getUserId(), newLimit);
        }
    }
}
