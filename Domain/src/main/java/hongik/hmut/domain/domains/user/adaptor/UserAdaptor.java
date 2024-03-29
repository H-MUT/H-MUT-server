package hongik.hmut.domain.domains.user.adaptor;


import hongik.hmut.core.annotation.Adaptor;
import hongik.hmut.domain.domains.user.domain.User;
import hongik.hmut.domain.domains.user.exception.UserNotFoundException;
import hongik.hmut.domain.domains.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Adaptor
@RequiredArgsConstructor
public class UserAdaptor {

    private final UserRepository userRepository;

    public Boolean existByOauthInfo(String email) {
        return userRepository.findByProfile_Email(email).isPresent();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User query(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}
