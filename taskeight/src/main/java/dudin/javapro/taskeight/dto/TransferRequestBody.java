package dudin.javapro.taskeight.dto;

import lombok.Data;

/**
 * @author SDudin
 */
@Data
public class TransferRequestBody {
    private Long userId;
    private String userName;
    private Long sbpTransfer;
}
