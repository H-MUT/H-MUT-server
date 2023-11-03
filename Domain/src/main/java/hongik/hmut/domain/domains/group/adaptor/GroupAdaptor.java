package hongik.hmut.domain.domains.group.adaptor;


import hongik.hmut.core.annotation.Adaptor;
import hongik.hmut.domain.domains.group.condition.GroupSearchCondition;
import hongik.hmut.domain.domains.group.domain.Group;
import hongik.hmut.domain.domains.group.domain.GroupUser;
import hongik.hmut.domain.domains.group.exception.GroupNotFoundException;
import hongik.hmut.domain.domains.group.repository.GroupRepository;
import hongik.hmut.domain.domains.group.repository.GroupUserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

@Adaptor
@RequiredArgsConstructor
public class GroupAdaptor {

    private final GroupRepository groupRepository;
    private final GroupUserRepository groupUserRepository;

    public Group query(Long groupId) {
        return groupRepository
                .findById(groupId)
                .orElseThrow(() -> GroupNotFoundException.EXCEPTION);
    }

    public List<Group> findAllGroups() {
        return groupRepository.findAll();
    }

    public Slice<Group> searchAllGroups(Pageable pageable, GroupSearchCondition condition) {
        return groupRepository.search(pageable, condition);
    }

    public Group createGroup(Group group) {
        return groupRepository.save(group);
    }

    public void joinGroup(GroupUser groupUser) {
        groupUserRepository.save(groupUser);
    }

    public void deleteGroup(Group group) {
        groupRepository.delete(group);
    }

    public List<GroupUser> queryGroupUsers(Group group) {
        return groupUserRepository.findAllByGroupId(group.getId());
    }

    public boolean checkGroupName(String groupName) {
        return groupRepository.existsAllByGroupName(groupName);
    }
}
