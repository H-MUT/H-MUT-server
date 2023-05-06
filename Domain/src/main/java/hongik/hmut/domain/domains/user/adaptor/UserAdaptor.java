package hongik.hmut.domain.domains.user.adaptor;

import hongik.hmut.core.annotation.Adaptor;
import hongik.hmut.domain.domains.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Adaptor
@RequiredArgsConstructor
public class UserAdaptor {

    private final UserRepository userRepository;


}
