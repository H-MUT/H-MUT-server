package hongik.hmut.domain.domains.user.repository;

import hongik.hmut.domain.domains.user.domain.RefreshTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepository extends JpaRepository<RefreshTokenEntity, Long> {

}
