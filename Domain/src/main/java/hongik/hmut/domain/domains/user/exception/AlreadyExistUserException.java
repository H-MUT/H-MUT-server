package hongik.hmut.domain.domains.user.exception;

import hongik.hmut.core.exception.BaseException;

public class AlreadyExistUserException extends BaseException {

    public static final BaseException EXCEPTION = new AlreadyExistUserException();

    private AlreadyExistUserException() {
        super(UserException.ALREADY_EXIST_USER_ERROR);
    }
}
