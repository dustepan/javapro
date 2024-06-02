package dudin.javapro.taskeight.repository;

import dudin.javapro.taskeight.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * @author SDudin
 */
@Repository
public interface TransferSpbRepository extends JpaRepository<UserEntity, Long> {
    Set<Long> findAllUserId();

    void saveUser(UserEntity user);

    void updateSbpLimits(Long id, Long tranferAmount);

    void updateAllUserSbpLimits(Long limits);

    UserEntity getUser(Long id);
}
