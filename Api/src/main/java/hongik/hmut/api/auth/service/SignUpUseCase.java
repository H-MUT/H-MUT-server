package hongik.hmut.api.auth.service;

import hongik.hmut.api.auth.model.KakaoUserInfoDto;
import hongik.hmut.api.auth.model.response.AuthResponse;
import hongik.hmut.api.auth.model.response.OauthLoginLinkResponse;
import hongik.hmut.api.auth.service.helper.KakaoOauthHelper;
import hongik.hmut.api.auth.service.helper.OIDCHelper;
import hongik.hmut.api.auth.service.helper.TokenGenerateHelper;
import hongik.hmut.core.annotation.UseCase;
import hongik.hmut.domain.domains.user.domain.Profile;
import hongik.hmut.domain.domains.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@UseCase
@RequiredArgsConstructor
@Slf4j
public class SignUpUseCase {

    private final TokenGenerateHelper tokenGenerateHelper;

    private final OIDCHelper oidcHelper;

    private final KakaoOauthHelper kakaoOauthHelper;

    public OauthLoginLinkResponse getKaKaoOauthLinkTest() {
        return new OauthLoginLinkResponse(kakaoOauthHelper.getKaKaoOauthLinkTest());
    }

    public OauthLoginLinkResponse getKaKaoOauthLink(String referer) {
        return new OauthLoginLinkResponse(kakaoOauthHelper.getKaKaoOauthLink(referer));
    }

    /**
     * 개발용 회원가입 upsert 입니다.
     *
     * @param code
     * @return
     */
    public AuthResponse upsertKakaoOauthUser(String code) {
        String oauthAccessToken = kakaoOauthHelper.getOauthTokenTest(code).getAccessToken();
        KakaoUserInfoDto oauthUserInfo = kakaoOauthHelper.getUserInfo(oauthAccessToken);

        Profile profile = oauthUserInfo.toProfile();
        User user = userDomainService.upsertUser(profile, oauthUserInfo.toOauthInfo());

        return tokenGenerateHelper.execute(user);
    }

    public AvailableRegisterResponse checkAvailableRegister(String idToken) {
        OauthInfo oauthInfo = kakaoOauthHelper.getOauthInfoByIdToken(idToken);
        return new AvailableRegisterResponse(userDomainService.checkUserCanRegister(oauthInfo));
    }

    public TokenAndUserResponse registerUserByOCIDToken(
        String idToken, RegisterRequest registerUserRequest) {

        OauthInfo oauthInfo = kakaoOauthHelper.getOauthInfoByIdToken(idToken);
        User user =
            userDomainService.registerUser(
                registerUserRequest.toProfile(),
                oauthInfo,
                registerUserRequest.getMarketingAgree());

        return tokenGenerateHelper.execute(user);
    }

    public OauthTokenResponse getCredentialFromKaKao(String code, String referer) {

        return OauthTokenResponse.from(kakaoOauthHelper.getOauthToken(code, referer));
    }

    public OauthTokenResponse getCredentialFromKaKaoTest(String code) {

        return OauthTokenResponse.from(kakaoOauthHelper.getOauthTokenTest(code));
    }
}
