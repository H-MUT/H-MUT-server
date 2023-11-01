package hongik.hmut.domain.domains.group.exception;


import hongik.hmut.core.exception.BaseException;

public class NotJoinedMemberException extends BaseException {

    public static final BaseException EXCEPTION = new NotJoinedMemberException();

    private NotJoinedMemberException() {
        super(GroupException.NOT_JOINED_MEMBER_ERROR);
    }
}
