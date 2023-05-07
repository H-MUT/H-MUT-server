package hongik.hmut.domain.domains.user.service;

import hongik.hmut.core.annotation.DomainService;
import hongik.hmut.domain.domains.user.adaptor.UserAdaptor;
import hongik.hmut.domain.domains.user.domain.OauthInfo;
import hongik.hmut.domain.domains.user.domain.Profile;
import hongik.hmut.domain.domains.user.domain.User;
import hongik.hmut.domain.domains.user.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@DomainService
@RequiredArgsConstructor
public class UserDomainService {

    private final UserAdaptor userAdaptor;
    private final UserValidator userValidator;

    @Transactional
    public User registerUser(Profile profile, OauthInfo oauthInfo) {
        userValidator.isNewUser(oauthInfo);

        User user = User.builder().profile(profile).oauthInfo(oauthInfo).build();
        return userAdaptor.save(user);
    }
}
