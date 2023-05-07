package hongik.hmut.domain.domains.user.adaptor;


import hongik.hmut.core.annotation.Adaptor;
import hongik.hmut.domain.domains.user.domain.OauthInfo;
import hongik.hmut.domain.domains.user.domain.User;
import hongik.hmut.domain.domains.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Adaptor
@RequiredArgsConstructor
public class UserAdaptor {

    private final UserRepository userRepository;

    public Boolean existByOauthInfo(OauthInfo oauthInfo) {
        return userRepository.findByOauthInfo(oauthInfo).isPresent();
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}
