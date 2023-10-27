package hongik.hmut.api.group.service;


import hongik.hmut.api.config.security.SecurityUtils;
import hongik.hmut.api.group.model.request.UpsertGroupRequest;
import hongik.hmut.core.annotation.UseCase;
import hongik.hmut.domain.domains.group.adaptor.GroupAdaptor;
import hongik.hmut.domain.domains.group.domain.Group;
import hongik.hmut.domain.domains.group.domain.GroupUser;
import hongik.hmut.domain.domains.tag.domain.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class CreateGroupUseCase {

    private final GroupAdaptor groupAdaptor;

    public void execute(UpsertGroupRequest body) {
        Long currentUserId = SecurityUtils.getCurrentUserId();
        Group group =
                Group.builder()
                        .groupName(body.getGroupName())
                        .introduceMessage(body.getIntroduceMessage())
                        .groupImageUrl(body.getImageUrl())
                        .description(body.getDescription())
                        .adminUserId(currentUserId)
                        .build();
        Group saveGroup = groupAdaptor.createGroup(group);

        createTags(saveGroup, body.getTags());

        createGroupUser(saveGroup, currentUserId);
    }

    private void createTags(Group group, List<String> tags) {
        List<Tag> createTags = tags.stream().map(tag -> Tag.builder().value(tag).build()).toList();
        group.updateTags(createTags);
    }

    private void createGroupUser(Group group, Long currentUserId) {
        groupAdaptor.joinGroup(
                GroupUser.builder().groupId(group.getId()).userId(currentUserId).build());
    }
}
