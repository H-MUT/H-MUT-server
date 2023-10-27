package hongik.hmut.api.group.service;


import hongik.hmut.core.annotation.UseCase;
import hongik.hmut.domain.domains.group.adaptor.GroupAdaptor;
import hongik.hmut.domain.domains.group.vo.GroupDetailInfoVo;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RetrieveGroupUseCase {

    private final GroupAdaptor groupAdaptor;

    public GroupDetailInfoVo execute(Long groupId) {
        return GroupDetailInfoVo.from(groupAdaptor.query(groupId));
    }
}
