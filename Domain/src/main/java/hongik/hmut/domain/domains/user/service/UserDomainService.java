package hongik.hmut.domain.domains.user.service;

import hongik.hmut.core.annotation.DomainService;
import hongik.hmut.domain.domains.user.adaptor.UserAdaptor;
import hongik.hmut.domain.domains.user.domain.OauthInfo;
import hongik.hmut.domain.domains.user.domain.Profile;
import hongik.hmut.domain.domains.user.domain.User;
import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class UserDomainService {

    private final UserAdaptor userAdaptor;


}
