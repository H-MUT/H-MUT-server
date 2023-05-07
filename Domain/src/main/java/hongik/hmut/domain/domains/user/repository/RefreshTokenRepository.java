package hongik.hmut.domain.domains.user.repository;


import hongik.hmut.domain.domains.user.domain.RefreshTokenEntity;
import org.springframework.data.repository.CrudRepository;

public interface RefreshTokenRepository extends CrudRepository<RefreshTokenEntity, Long> {}
