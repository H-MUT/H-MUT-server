package hongik.hmut.domain.domains.group.exception;


import hongik.hmut.core.exception.BaseException;

public class AlreadyJoinGroupUserException extends BaseException {

    public static final BaseException EXCEPTION = new AlreadyJoinGroupUserException();

    private AlreadyJoinGroupUserException() {
        super(GroupException.ALREADY_JOIN_GROUP_USER_ERROR);
    }
}
