package dudin.javapro.taskeight.schedule;

import dudin.javapro.taskeight.repository.TransferSpbRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author SDudin
 */
@Component
public class TransferSchedule {
    @Value("sbp-limits")
    private BigDecimal limits;
    
    private final TransferSpbRepository transferSpbRepository;

    public TransferSchedule(TransferSpbRepository transferSpbRepository) {
        this.transferSpbRepository = transferSpbRepository;
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void updateLimitsForAllUsersDay() {
        transferSpbRepository.updateAllUserSbpLimits(limits);
    }
}
