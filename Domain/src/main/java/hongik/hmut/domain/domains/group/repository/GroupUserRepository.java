package hongik.hmut.domain.domains.group.repository;


import hongik.hmut.domain.domains.group.domain.GroupUser;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupUserRepository extends JpaRepository<GroupUser, Long> {

    List<GroupUser> findAllByGroupId(Long groupId);
}
