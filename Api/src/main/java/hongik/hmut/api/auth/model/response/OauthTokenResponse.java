package hongik.hmut.api.auth.model.response;


import hongik.hmut.infrastructure.outer.api.oauth.dto.KakaoTokenResponse;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OauthTokenResponse {

    private String accessToken;
    private String refreshToken;
    private String idToken;

    public static OauthTokenResponse from(KakaoTokenResponse kakaoTokenResponse) {
        return OauthTokenResponse.builder()
                .accessToken(kakaoTokenResponse.getAccessToken())
                .refreshToken(kakaoTokenResponse.getRefreshToken())
                .idToken(kakaoTokenResponse.getIdToken())
                .build();
    }
}
