package hongik.hmut.domain.domains.user.service;


import hongik.hmut.core.annotation.DomainService;
import hongik.hmut.domain.domains.group.domain.Group;
import hongik.hmut.domain.domains.user.adaptor.UserAdaptor;
import hongik.hmut.domain.domains.user.domain.Profile;
import hongik.hmut.domain.domains.user.domain.User;
import hongik.hmut.domain.domains.user.repository.UserRepository;
import hongik.hmut.domain.domains.user.validator.UserValidator;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@DomainService
@RequiredArgsConstructor
public class UserDomainService {

    private final UserAdaptor userAdaptor;
    private final UserValidator userValidator;
    private final UserRepository userRepository;

    @Transactional
    public User registerUser(List<Group.TagValue> tagValues, Profile profile) {
        userValidator.isNewUser(profile.getEmail());

        User user = User.builder().profile(profile).tagValues(tagValues).build();
        return userAdaptor.save(user);
    }

    //    @Transactional
    //    public User registerUserForTest(Profile profile, OauthInfo oauthInfo) {
    //        return userRepository
    //                .findByOauthInfo(oauthInfo)
    //                .orElseGet(
    //                        () ->
    //                                userAdaptor.save(
    //                                        User.builder()
    //                                                .oauthInfo(oauthInfo)
    //                                                .profile(profile)
    //                                                .build()));
    //    }
    //
    //    @Transactional(readOnly = true)
    //    public User loginUser(OauthInfo oauthInfo) {
    //        return userRepository
    //                .findByOauthInfo(oauthInfo)
    //                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    //    }
}
