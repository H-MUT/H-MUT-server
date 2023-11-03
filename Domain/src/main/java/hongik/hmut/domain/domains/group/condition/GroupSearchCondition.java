package hongik.hmut.domain.domains.group.condition;


import hongik.hmut.domain.domains.group.domain.Group.Tag;
import java.util.List;
import lombok.Data;

@Data
public class GroupSearchCondition {

    private final List<Tag> tags;

    private final String groupName;
}
