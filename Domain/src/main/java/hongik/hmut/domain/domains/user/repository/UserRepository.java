package hongik.hmut.domain.domains.user.repository;

import hongik.hmut.domain.domains.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
