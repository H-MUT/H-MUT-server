package hongik.hmut.domain.domains.user.validator;

import hongik.hmut.core.annotation.Validator;
import hongik.hmut.domain.domains.user.adaptor.UserAdaptor;
import hongik.hmut.domain.domains.user.domain.OauthInfo;
import hongik.hmut.domain.domains.user.exception.AlreadyExistUserException;
import lombok.RequiredArgsConstructor;

@Validator
@RequiredArgsConstructor
public class UserValidator {

    private final UserAdaptor userAdaptor;

    public void isNewUser(OauthInfo oauthInfo) {
        if (userAdaptor.existByOauthInfo(oauthInfo)) {
            throw AlreadyExistUserException.EXCEPTION;
        }
    }

}
