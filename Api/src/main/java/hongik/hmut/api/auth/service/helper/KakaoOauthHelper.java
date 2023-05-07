package hongik.hmut.api.auth.service.helper;

import static hongik.hmut.core.consts.StaticVal.BEARER;

import hongik.hmut.api.auth.model.KakaoUserInfoDto;
import hongik.hmut.core.annotation.Helper;
import hongik.hmut.core.dto.OIDCDto;
import hongik.hmut.core.properties.OauthProperties;
import hongik.hmut.domain.domains.user.domain.OauthInfo;
import hongik.hmut.domain.domains.user.domain.OauthProvider;
import hongik.hmut.outer.api.oauth.client.KakaoInfoClient;
import hongik.hmut.outer.api.oauth.client.KakaoOauthClient;
import hongik.hmut.outer.api.oauth.dto.KakaoInfoResponse;
import hongik.hmut.outer.api.oauth.dto.KakaoTokenResponse;
import hongik.hmut.outer.api.oauth.dto.OIDCResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Helper
public class KakaoOauthHelper {

    private final OauthProperties oauthProperties;

    private final KakaoInfoClient kakaoInfoClient;
    private final KakaoOauthClient kakaoOauthClient;

    private final OIDCHelper oidcHelper;

    private static final String KAKAO_OAUTH_QUERY_STRING =
            "/oauth/authorize?client_id=%s&redirect_uri=%s&response_type=code";

    public String getKaKaoOauthLinkTest() {
        return oauthProperties.getKakaoBaseUrl()
                + String.format(
                        KAKAO_OAUTH_QUERY_STRING,
                        oauthProperties.getKakaoClientId(),
                        oauthProperties.getKakaoRedirectUrl());
    }

    public String getKaKaoOauthLink(String referer) {
        System.out.println("referer = " + referer);
        return oauthProperties.getKakaoBaseUrl()
                + String.format(
                        KAKAO_OAUTH_QUERY_STRING,
                        oauthProperties.getKakaoClientId(),
                        referer + "kakao/callback");
    }

    public KakaoTokenResponse getOauthToken(String code, String referer) {

        System.out.println("oauthProperties = " + oauthProperties.getKakaoClientId());
        System.out.println("oauthProperties = " + oauthProperties.getKakaoClientSecret());


        return kakaoOauthClient.kakaoAuth(
                oauthProperties.getKakaoClientId(),
                referer + "kakao/callback",
                code,
                oauthProperties.getKakaoClientSecret());
    }

    public KakaoTokenResponse getOauthTokenTest(String code) {

        return kakaoOauthClient.kakaoAuth(
                oauthProperties.getKakaoClientId(),
                oauthProperties.getKakaoRedirectUrl(),
                code,
                oauthProperties.getKakaoClientSecret());
    }

    public KakaoUserInfoDto getUserInfo(String oauthAccessToken) {
        System.out.println("oauthAccessToken = " + oauthAccessToken);
        KakaoInfoResponse response = kakaoInfoClient.kakaoUserInfo(BEARER + oauthAccessToken);

        return KakaoUserInfoDto.builder()
                .oauthProvider(OauthProvider.KAKAO)
                .userName(response.getName())
                .phoneNum(response.getPhoneNum())
                .profileImage(response.getProfileUrl())
                .email(response.getEmail())
                .oauthId(response.getId())
                .build();
    }

    public OIDCDto getOIDCDecodePayload(String token) {
        OIDCResponse oidcPublicKeysResponse = kakaoOauthClient.getKakaoOIDCOpenKeys();
        return oidcHelper.getPayloadFromIdToken(
                token,
                oauthProperties.getKakaoBaseUrl(),
                oauthProperties.getKakaoAppId(),
                oidcPublicKeysResponse);
    }

    public OauthInfo getOauthInfoByIdToken(String idToken) {
        OIDCDto oidcDecodePayload = getOIDCDecodePayload(idToken);
        return OauthInfo.builder()
                .provider(OauthProvider.KAKAO)
                .oid(oidcDecodePayload.getSub())
                .build();
    }

    //    public void unlink(String oid) {
    //        String kakaoAdminKey = oauthProperties.getKakaoAdminKey();
    //        UnlinkKaKaoTarget unlinkKaKaoTarget = UnlinkKaKaoTarget.from(oid);
    //        String header = "KakaoAK " + kakaoAdminKey;
    //        kakaoInfoClient.unlinkUser(header, unlinkKaKaoTarget);
    //    }
}
