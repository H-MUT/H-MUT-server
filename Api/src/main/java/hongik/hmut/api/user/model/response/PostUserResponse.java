package hongik.hmut.api.user.model.response;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostUserResponse {

    private final String accessToken;

    private final String refreshToken;

    private final Long userId;
}
