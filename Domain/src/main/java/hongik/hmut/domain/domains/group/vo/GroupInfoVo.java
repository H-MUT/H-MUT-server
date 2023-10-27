package hongik.hmut.domain.domains.group.vo;


import hongik.hmut.domain.domains.group.domain.Group;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GroupInfoVo {

    private final Long groupId;

    private final String groupName;

    private final String introduceMessage;

    private final String groupImage;

    public static GroupInfoVo from(Group group) {
        return GroupInfoVo.builder()
                .groupId(group.getId())
                .groupName(group.getGroupName())
                .introduceMessage(group.getIntroduceMessage())
                .groupImage(group.getGroupImageUrl())
                .build();
    }
}
