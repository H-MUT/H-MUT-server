package hongik.hmut.domain.domains.group.adaptor;


import hongik.hmut.core.annotation.Adaptor;
import hongik.hmut.domain.domains.group.repository.GroupRepository;
import lombok.RequiredArgsConstructor;

@Adaptor
@RequiredArgsConstructor
public class GroupAdaptor {

    private final GroupRepository groupRepository;
}
