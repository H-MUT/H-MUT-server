package hongik.hmut.api.auth.service;


import hongik.hmut.api.auth.model.KakaoUserInfoDto;
import hongik.hmut.api.auth.model.request.RegisterRequest;
import hongik.hmut.api.auth.model.response.AuthResponse;
import hongik.hmut.api.auth.model.response.OauthLoginLinkResponse;
import hongik.hmut.api.auth.model.response.OauthTokenResponse;
import hongik.hmut.api.auth.service.helper.KakaoOauthHelper;
import hongik.hmut.api.auth.service.helper.OIDCHelper;
import hongik.hmut.api.auth.service.helper.TokenGenerateHelper;
import hongik.hmut.core.annotation.UseCase;
import hongik.hmut.domain.domains.user.domain.OauthInfo;
import hongik.hmut.domain.domains.user.domain.User;
import hongik.hmut.domain.domains.user.service.UserDomainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@UseCase
@RequiredArgsConstructor
@Slf4j
public class SignUpUseCase {

    private final TokenGenerateHelper tokenGenerateHelper;

    private final OIDCHelper oidcHelper;

    private final KakaoOauthHelper kakaoOauthHelper;

    private final UserDomainService userDomainService;

    public OauthLoginLinkResponse getKaKaoOauthLinkTest() {
        return new OauthLoginLinkResponse(kakaoOauthHelper.getKaKaoOauthLinkTest());
    }

    public OauthLoginLinkResponse getKaKaoOauthLink(String referer) {
        return new OauthLoginLinkResponse(kakaoOauthHelper.getKaKaoOauthLink(referer));
    }

    public AuthResponse registerUserByOICDToken(
            String idToken, RegisterRequest registerUserRequest) {

        OauthInfo oauthInfo = kakaoOauthHelper.getOauthInfoByIdToken(idToken);
        User user = userDomainService.registerUser(registerUserRequest.toProfile(), oauthInfo);

        return tokenGenerateHelper.execute(user);
    }

    public AuthResponse registerUserByKakaoCode(String code) {
        String accessToken = kakaoOauthHelper.getOauthTokenTest(code).getAccessToken();

        System.out.println("accessToken = " + accessToken);
        KakaoUserInfoDto userInfo = kakaoOauthHelper.getUserInfo(accessToken);

        System.out.println("userInfo = " + userInfo);
        User user = userDomainService.registerUser(userInfo.toProfile(), userInfo.toOauthInfo());

        return tokenGenerateHelper.execute(user);
    }

    public OauthTokenResponse getCredentialFromKaKao(String code, String referer) {

        return OauthTokenResponse.from(kakaoOauthHelper.getOauthToken(code, referer));
    }

    public OauthTokenResponse getCredentialFromKaKaoTest(String code) {

        return OauthTokenResponse.from(kakaoOauthHelper.getOauthTokenTest(code));
    }
}
