package hongik.hmut.api.utils;


import hongik.hmut.api.config.security.SecurityUtils;
import hongik.hmut.domain.domains.user.adaptor.UserAdaptor;
import hongik.hmut.domain.domains.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserUtils {

    private final UserAdaptor userAdaptor;

    public Long getUserId() {
        return SecurityUtils.getCurrentUserId();
    }

    public User getUser() {
        return userAdaptor.query(SecurityUtils.getCurrentUserId());
    }
}
