package hongik.hmut.api.group.service;


import hongik.hmut.api.config.security.SecurityUtils;
import hongik.hmut.api.group.model.request.UpsertGroupRequest;
import hongik.hmut.core.annotation.UseCase;
import hongik.hmut.domain.domains.group.adaptor.GroupAdaptor;
import hongik.hmut.domain.domains.group.domain.Group;
import hongik.hmut.domain.domains.group.validator.GroupValidator;
import hongik.hmut.domain.domains.tag.domain.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class UpdateGroupInfoUseCase {

    private final GroupAdaptor groupAdaptor;
    private final GroupValidator groupValidator;

    public void execute(UpsertGroupRequest body, Long groupId) {
        Long currentUserId = SecurityUtils.getCurrentUserId();
        Group group = groupAdaptor.query(groupId);

        groupValidator.validateGroupAdmin(group, currentUserId);

        group.update(
                body.getGroupName(),
                body.getIntroduceMessage(),
                body.getDescription(),
                body.getImageUrl());

        updateTags(group, body.getTags());
    }

    private void updateTags(Group group, List<String> tags) {
        group.clearTags();
        List<Tag> createTags = tags.stream().map(tag -> Tag.builder().value(tag).build()).toList();
        group.updateTags(createTags);
    }
}
