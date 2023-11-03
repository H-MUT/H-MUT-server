package hongik.hmut.api.user.service;


import hongik.hmut.api.auth.model.request.RegisterRequest;
import hongik.hmut.api.auth.model.response.AuthResponse;
import hongik.hmut.api.user.model.response.PostUserResponse;
import hongik.hmut.api.user.model.response.UserInfoResponse;
import hongik.hmut.api.utils.UserUtils;
import hongik.hmut.core.annotation.UseCase;
import hongik.hmut.core.jwt.JwtTokenProvider;
import hongik.hmut.domain.domains.user.domain.OauthInfo;
import hongik.hmut.domain.domains.user.domain.User;
import hongik.hmut.domain.domains.user.service.UserDomainService;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class UserInfoUseCase {

    private final UserDomainService userDomainService;

    private final UserUtils userUtils;

    private final JwtTokenProvider jwtTokenProvider;


    public UserInfoResponse execute() {
        return UserInfoResponse.from(userUtils.getUser());
    }

    public PostUserResponse registerUser(RegisterRequest registerUserRequest) {

        User user = userDomainService.registerUser(registerUserRequest.toProfile());
        String newAccessToken =
                jwtTokenProvider.generateAccessToken(user.getId());
        String newRefreshToken = jwtTokenProvider.generateRefreshToken(user.getId());

        return PostUserResponse.builder()
                .userId(user.getId())
                .accessToken(newAccessToken)
                .refreshToken(newRefreshToken)
                .build();
    }
}
