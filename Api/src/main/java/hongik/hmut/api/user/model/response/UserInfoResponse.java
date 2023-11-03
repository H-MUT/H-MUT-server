package hongik.hmut.api.user.model.response;


import hongik.hmut.domain.domains.user.domain.OauthProvider;
import hongik.hmut.domain.domains.user.domain.Profile;
import hongik.hmut.domain.domains.user.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserInfoResponse {

    private Long userId;
    private Profile profile;
    private OauthProvider provider;

    public static UserInfoResponse from(User user) {
        return UserInfoResponse.builder().userId(user.getId()).profile(user.getProfile()).build();
    }
}
