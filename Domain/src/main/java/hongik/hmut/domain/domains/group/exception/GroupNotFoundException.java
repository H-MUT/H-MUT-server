package hongik.hmut.domain.domains.group.exception;


import hongik.hmut.core.exception.BaseException;

public class GroupNotFoundException extends BaseException {

    public static final BaseException EXCEPTION = new GroupNotFoundException();

    private GroupNotFoundException() {
        super(GroupException.GROUP_NOT_FOUND_ERROR);
    }
}
