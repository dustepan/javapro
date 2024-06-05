package dudin.javapro.taskeight.repository;

import dudin.javapro.taskeight.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Set;

/**
 * @author SDudin
 */
@Repository
public interface TransferSpbRepository extends JpaRepository<UserEntity, Long> {
    Set<Long> findAllUserId();

    void saveUser(UserEntity user);

    void updateSbpLimits(Long id, BigDecimal tranferAmount);

    @Modifying
    @Query("""
            UPDATE UserEntity u SET u.sbpLimits = :limits
            """)
    void updateAllUserSbpLimits(@Param("limits") BigDecimal limits);

    UserEntity getUser(Long id);
}
