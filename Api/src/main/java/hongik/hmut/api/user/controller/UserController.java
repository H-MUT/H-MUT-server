package hongik.hmut.api.user.controller;


import hongik.hmut.api.auth.model.request.RegisterRequest;
import hongik.hmut.api.user.model.response.PostUserResponse;
import hongik.hmut.api.user.model.response.UserInfoResponse;
import hongik.hmut.api.user.service.UserInfoUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@SecurityRequirement(name = "access-token")
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Tag(name = "1.3 [유저]")
public class UserController {

    private final UserInfoUseCase userInfoUseCase;

    @Operation(summary = "내 정보 조회")
    @GetMapping(produces = "application/json; charset=utf-8")
    public UserInfoResponse getUserInfo() {
        return userInfoUseCase.execute();
    }

}
