package dudin.javapro.taskeight.service;

import dudin.javapro.taskeight.dto.TransferRequestBody;
import dudin.javapro.taskeight.entity.UserEntity;
import dudin.javapro.taskeight.exception.TransferException;
import dudin.javapro.taskeight.repository.TransferSpbRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Set;

/**
 * @author SDudin
 */
@Service
public class TransferMoneySbpServiceImpl implements TransferMoneyService {
    @Value("sbp-limits")
    private BigDecimal limits;

    private final TransferSpbRepository transferSpbRepository;

    public TransferMoneySbpServiceImpl(TransferSpbRepository transferSpbRepository) {
        this.transferSpbRepository = transferSpbRepository;
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
        if (repositoryUser.getSbpLimits().compareTo(transferRequestBody.getSbpTransfer()) >= 0) {
            BigDecimal newLimit = repositoryUser.getSbpLimits().subtract(transferRequestBody.getSbpTransfer());
            transferSpbRepository.updateSbpLimits(transferRequestBody.getUserId(), newLimit);
        } else {
            throw new TransferException("Лимит превышен");
        }
    }

    private void saveNewUserAndUpdateLimitsSbp(TransferRequestBody transferRequestBody) {
        transferSpbRepository.saveUser(new UserEntity(transferRequestBody.getUserId(), transferRequestBody.getUserName(), limits));
        BigDecimal newLimit = limits.subtract(transferRequestBody.getSbpTransfer());
        transferSpbRepository.updateSbpLimits(transferRequestBody.getUserId(), newLimit);
    }
}
