package hongik.hmut.api.auth.model;

import hongik.hmut.domain.domains.user.domain.OauthInfo;
import hongik.hmut.domain.domains.user.domain.OauthProvider;
import hongik.hmut.domain.domains.user.domain.Profile;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class KakaoUserInfoDto {

    private final String oauthId;

    private final String email;
    private final String phoneNum;
    private final String profileImage;
    private final String userName;
    // oauth 제공자
    private final OauthProvider oauthProvider;

    public Profile toProfile() {
        return Profile.builder()
            .thumbNail(this.profileImage)
            .phoneNum(phoneNum)
            .userName(userName)
            .email(email)
            .build();
    }

    public OauthInfo toOauthInfo() {
        return OauthInfo.builder().oid(oauthId).provider(oauthProvider).build();
    }
}
