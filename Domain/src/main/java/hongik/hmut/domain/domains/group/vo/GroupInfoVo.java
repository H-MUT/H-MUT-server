package hongik.hmut.domain.domains.group.vo;


import hongik.hmut.domain.domains.group.domain.Group;
import hongik.hmut.domain.domains.group.domain.Group.GroupFrequency;
import hongik.hmut.domain.domains.group.domain.Group.Tag;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GroupInfoVo {

    private final String imageUrl;

    private final String adminName;

    private final String groupName;

    private final Tag tag;

    private final GroupFrequency groupFrequency;

    private final String introduceMessage;

    private final String description;

    private final int groupMember;

    private final Long groupId;

    public static GroupInfoVo from(Group group) {
        return GroupInfoVo.builder()
                .imageUrl(group.getGroupImageUrl())
                .adminName(group.getAdminUser().getProfile().getUserName())
                .groupName(group.getGroupName())
                .tag(group.getTag())
                .groupFrequency(group.getGroupFrequency())
                .introduceMessage(group.getIntroduceMessage())
                .description(group.getDescription())
                .groupMember(group.getGroupUsers().size())
                .groupId(group.getId())
                .build();
    }
}
