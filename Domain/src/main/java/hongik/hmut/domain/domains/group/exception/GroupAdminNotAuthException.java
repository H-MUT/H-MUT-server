package hongik.hmut.domain.domains.group.exception;


import hongik.hmut.core.exception.BaseException;

public class GroupAdminNotAuthException extends BaseException {

    public static final BaseException EXCEPTION = new GroupAdminNotAuthException();

    private GroupAdminNotAuthException() {
        super(GroupException.GROUP_ADMIN_NOT_MATCHED_ERROR);
    }
}
