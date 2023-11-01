package hongik.hmut.domain.domains.group.validator;


import hongik.hmut.core.annotation.Validator;
import hongik.hmut.domain.domains.group.adaptor.GroupAdaptor;
import hongik.hmut.domain.domains.group.domain.Group;
import hongik.hmut.domain.domains.group.domain.GroupUser;
import hongik.hmut.domain.domains.group.exception.AlreadyJoinGroupUserException;
import hongik.hmut.domain.domains.group.exception.GroupAdminNotAuthException;
import hongik.hmut.domain.domains.group.exception.NotJoinedMemberException;
import java.util.List;
import lombok.RequiredArgsConstructor;

@Validator
@RequiredArgsConstructor
public class GroupValidator {

    private final GroupAdaptor groupAdaptor;

    public void validateGroupAdmin(Group group, Long adminUserId) {
        if (!group.getAdminUserId().equals(adminUserId)) {
            throw GroupAdminNotAuthException.EXCEPTION;
        }
    }

    public void validateAlreadyJoinGroup(Group group, Long currentUserId) {
        List<GroupUser> groupUsers = groupAdaptor.queryGroupUsers(group);

        if (groupUsers.stream().map(GroupUser::getUserId).toList().contains(currentUserId)) {
            throw AlreadyJoinGroupUserException.EXCEPTION;
        }
    }

    public void validateNotJoinGroup(Group group, Long currentUserId) {
        List<GroupUser> groupUsers = groupAdaptor.queryGroupUsers(group);

        if (!groupUsers.stream().map(GroupUser::getUserId).toList().contains(currentUserId)) {
            throw NotJoinedMemberException.EXCEPTION;
        }
    }
}
