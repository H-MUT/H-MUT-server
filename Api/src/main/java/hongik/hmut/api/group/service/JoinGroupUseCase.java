package hongik.hmut.api.group.service;


import hongik.hmut.api.config.security.SecurityUtils;
import hongik.hmut.core.annotation.UseCase;
import hongik.hmut.domain.domains.group.adaptor.GroupAdaptor;
import hongik.hmut.domain.domains.group.domain.Group;
import hongik.hmut.domain.domains.group.domain.GroupUser;
import hongik.hmut.domain.domains.group.validator.GroupValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class JoinGroupUseCase {

    private final GroupAdaptor groupAdaptor;
    private final GroupValidator groupValidator;

    public void execute(Long groupId) {
        Long currentUserId = SecurityUtils.getCurrentUserId();
        Group group = groupAdaptor.query(groupId);

        groupValidator.validateAlreadyJoinGroup(group, currentUserId);

        groupAdaptor.joinGroup(GroupUser.builder().groupId(groupId).userId(currentUserId).build());
    }
}
