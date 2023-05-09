package hongik.hmut.domain.domains.user.adaptor;


import hongik.hmut.core.annotation.Adaptor;
import hongik.hmut.domain.domains.user.domain.RefreshTokenEntity;
import hongik.hmut.domain.domains.user.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;

@Adaptor
@RequiredArgsConstructor
public class RefreshTokenAdaptor {

    private final RefreshTokenRepository refreshTokenRepository;

    public void save(RefreshTokenEntity refreshToken) {
        refreshTokenRepository.save(refreshToken);
    }
}
