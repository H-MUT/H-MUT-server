package hongik.hmut.api.group.service;


import hongik.hmut.api.config.security.SecurityUtils;
import hongik.hmut.api.group.model.request.UpsertGroupRequest;
import hongik.hmut.core.annotation.UseCase;
import hongik.hmut.domain.domains.group.adaptor.GroupAdaptor;
import hongik.hmut.domain.domains.group.domain.Group;
import hongik.hmut.domain.domains.group.domain.GroupUser;
import hongik.hmut.domain.domains.user.adaptor.UserAdaptor;
import hongik.hmut.domain.domains.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class CreateGroupUseCase {

    private final GroupAdaptor groupAdaptor;
    private final UserAdaptor userAdaptor;

    public void execute(UpsertGroupRequest body) {
        Long currentUserId = SecurityUtils.getCurrentUserId();
        User user = userAdaptor.query(currentUserId);
        Group group =
                Group.builder()
                        .groupName(body.getGroupName())
                        .introduceMessage(body.getIntroduceMessage())
                        .groupImageUrl(body.getImageUrl())
                        .description(body.getDescription())
                        .adminUser(user)
                        .groupFrequency(body.getGroupFrequency())
                        .tagValue(body.getTagValue())
                        .build();
        Group saveGroup = groupAdaptor.createGroup(group);

        createGroupUser(saveGroup, currentUserId);
    }

    public boolean checkGroupName(String groupName) {
        return groupAdaptor.checkGroupName(groupName);
    }

    private void createGroupUser(Group group, Long currentUserId) {
        groupAdaptor.joinGroup(GroupUser.builder().group(group).userId(currentUserId).build());
    }
}
