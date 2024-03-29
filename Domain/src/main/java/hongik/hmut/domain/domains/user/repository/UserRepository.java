package hongik.hmut.domain.domains.user.repository;


import hongik.hmut.domain.domains.user.domain.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByProfile_Email(String email);
}
