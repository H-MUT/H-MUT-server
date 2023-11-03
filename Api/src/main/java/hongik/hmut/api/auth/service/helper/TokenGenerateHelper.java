package hongik.hmut.api.auth.service.helper;


import hongik.hmut.api.auth.model.response.AuthResponse;
import hongik.hmut.core.annotation.Helper;
import hongik.hmut.core.jwt.JwtTokenProvider;
import hongik.hmut.domain.domains.user.adaptor.RefreshTokenAdaptor;
import hongik.hmut.domain.domains.user.domain.RefreshTokenEntity;
import hongik.hmut.domain.domains.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Helper
@RequiredArgsConstructor
public class TokenGenerateHelper {

    private final JwtTokenProvider jwtTokenProvider;

    private final RefreshTokenAdaptor refreshTokenAdaptor;

    @Transactional
    public AuthResponse execute(User user) {
        String newAccessToken =
                jwtTokenProvider.generateAccessToken(user.getId());
        String newRefreshToken = jwtTokenProvider.generateRefreshToken(user.getId());

        RefreshTokenEntity newRefreshTokenEntity =
                RefreshTokenEntity.builder()
                        .refreshToken(newRefreshToken)
                        .id(user.getId())
                        .ttl(jwtTokenProvider.getRefreshTokenTTlSecond())
                        .build();
        refreshTokenAdaptor.save(newRefreshTokenEntity);

        return AuthResponse.builder()
                .userId(user.getId())
                .accessToken(newAccessToken)
                .refreshToken(newRefreshToken)
                .build();
    }
}
