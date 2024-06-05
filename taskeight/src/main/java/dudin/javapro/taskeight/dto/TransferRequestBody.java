package dudin.javapro.taskeight.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author SDudin
 */
@Data
public class TransferRequestBody {
    private Long userId;
    private String userName;
    private BigDecimal sbpTransfer;
}
