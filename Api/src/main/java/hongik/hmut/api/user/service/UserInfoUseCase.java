package hongik.hmut.api.user.service;


import hongik.hmut.api.user.model.response.UserInfoResponse;
import hongik.hmut.api.utils.UserUtils;
import hongik.hmut.core.annotation.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class UserInfoUseCase {

    private final UserUtils userUtils;

    public UserInfoResponse execute() {
        return UserInfoResponse.from(userUtils.getUser());
    }
}
