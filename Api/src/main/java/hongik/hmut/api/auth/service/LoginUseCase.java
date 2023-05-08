package hongik.hmut.api.auth.service;

import hongik.hmut.api.auth.model.response.AuthResponse;
import hongik.hmut.api.auth.service.helper.KakaoOauthHelper;
import hongik.hmut.api.auth.service.helper.TokenGenerateHelper;
import hongik.hmut.core.annotation.UseCase;
import hongik.hmut.domain.domains.user.domain.User;
import hongik.hmut.domain.domains.user.service.UserDomainService;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class LoginUseCase {

    private final UserDomainService userDomainService;
    private final KakaoOauthHelper kakaoOauthHelper;
    private final TokenGenerateHelper tokenGenerateHelper;

    public AuthResponse execute(String idToken) {
        User user = userDomainService.loginUser(kakaoOauthHelper.getOauthInfoByIdToken(idToken));
        System.out.println("user = " + user.getId());
        return tokenGenerateHelper.execute(user);
    }
}
