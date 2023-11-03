package hongik.hmut.domain.domains.group.condition;


import hongik.hmut.domain.domains.group.domain.Group;
import java.util.List;
import lombok.Data;

@Data
public class GroupSearchCondition {

    private final List<Group.TagValue> tagValues;

    private final String groupName;
}
