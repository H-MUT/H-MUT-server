package hongik.hmut.exception;

import hongik.hmut.core.exception.BaseException;
import hongik.hmut.core.exception.GlobalException;

public class FeignException extends BaseException {

    public static final BaseException EXCEPTION = new FeignException();

    private FeignException() {
        super(GlobalException.FEIGN_SERVER_ERROR);
    }
}
