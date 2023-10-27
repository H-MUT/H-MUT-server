package hongik.hmut.domain.domains.group.vo;


import hongik.hmut.domain.domains.group.domain.Group;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GroupDetailInfoVo {

    private final GroupInfoVo groupInfo;

    private final String description;

    private final LocalDateTime createdAt;

    public static GroupDetailInfoVo from(Group group) {
        return GroupDetailInfoVo.builder()
                .groupInfo(GroupInfoVo.from(group))
                .description(group.getDescription())
                .createdAt(group.getCreatedAt().toLocalDateTime())
                .build();
    }
}
