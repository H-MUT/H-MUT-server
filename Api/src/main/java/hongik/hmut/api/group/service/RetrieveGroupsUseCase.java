package hongik.hmut.api.group.service;


import hongik.hmut.core.annotation.UseCase;
import hongik.hmut.domain.domains.group.adaptor.GroupAdaptor;
import hongik.hmut.domain.domains.group.condition.GroupSearchCondition;
import hongik.hmut.domain.domains.group.vo.GroupInfoVo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RetrieveGroupsUseCase {

    private final GroupAdaptor groupAdaptor;

    public Slice<GroupInfoVo> execute(Pageable pageable, GroupSearchCondition condition) {
        return groupAdaptor.searchAllGroups(pageable, condition).map(GroupInfoVo::from);
    }
}
