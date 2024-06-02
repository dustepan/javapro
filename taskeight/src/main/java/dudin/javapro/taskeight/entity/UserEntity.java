package dudin.javapro.taskeight.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author SDudin
 */
@Entity
@Getter
@Setter
@Table(name = "users")
public class UserEntity {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "spb_limits")
    private Long sbpLimits;

    public UserEntity(Long userId, String userName, Long sbpLimits) {
        this.userId = userId;
        this.userName = userName;
        this.sbpLimits = sbpLimits;
    }

    public UserEntity() {

    }
}
