package hongik.hmut.domain.domains.group.repository;


import hongik.hmut.domain.domains.group.domain.Group;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface GroupCustomRepository {

    Slice<Group> search(Pageable pageable, String tag);
}
