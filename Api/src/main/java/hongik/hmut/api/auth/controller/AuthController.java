package hongik.hmut.api.auth.controller;


import hongik.hmut.api.auth.model.request.RegisterRequest;
import hongik.hmut.api.auth.service.LoginUseCase;
import hongik.hmut.api.auth.service.SignUpUseCase;
import hongik.hmut.api.user.model.response.PostUserResponse;
import hongik.hmut.api.user.service.UserInfoUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(value = "/auth")
@RequiredArgsConstructor
@Tag(name = "1-1. [인증]")
public class AuthController {

    private final SignUpUseCase signUpUseCase;
    private final LoginUseCase loginUseCase;
    private final UserInfoUseCase userInfoUseCase;

    @Operation(summary = "회원가입")
    @PostMapping("/join")
    public PostUserResponse join(@Valid @RequestBody RegisterRequest registerRequest) {
        return userInfoUseCase.registerUser(registerRequest);
    }

    //    @Operation(summary = "kakao oauth 링크발급 (백엔드용)", description = "kakao 링크를 받아볼수 있습니다.")
    //    @Tag(name = "1-2. [카카오]")
    //    @GetMapping("/oauth/kakao/link/dev")
    //    public OauthLoginLinkResponse getKakaoLoginLinkForDev() {
    //        return signUpUseCase.getKaKaoOauthLinkTest();
    //    }
    //
    //    @Operation(summary = "kakao oauth 링크발급 (프론트용)", description = "kakao 링크를 받아볼수 있습니다.")
    //    @Tag(name = "1-2. [카카오]")
    //    @GetMapping("/oauth/kakao/link")
    //    public OauthLoginLinkResponse getKakaoLoginLink(
    //            @RequestHeader(required = false) String referer,
    //            @RequestHeader(required = false) String host) {
    //
    //        // dev, production 환경에서
    //        if (referer.contains(host)) {
    //            log.info("/oauth/kakao" + host);
    //            String format = String.format("https://%s/", host);
    //            return signUpUseCase.getKaKaoOauthLink(format);
    //        }
    //        return signUpUseCase.getKaKaoOauthLink(referer);
    //    }
    //
    //    @Operation(summary = "kakao code를 통해 token 발급")
    //    @Tag(name = "1-2. [카카오]")
    //    @GetMapping("/oauth/kakao")
    //    public OauthTokenResponse getKakaoCredentialInfo(
    //            @RequestParam String code,
    //            @RequestHeader(required = false) String referer,
    //            @RequestHeader(required = false) String host) {
    //
    //        // dev, production 환경에서
    //        if (referer.contains(host)) {
    //            log.info("/oauth/kakao" + host);
    //            String format = String.format("https://%s/", host);
    //            return signUpUseCase.getCredentialFromKaKao(code, format);
    //        }
    //        return signUpUseCase.getCredentialFromKaKao(code, referer);
    //    }
    //
    //    @Operation(summary = "발급받은 idToken을 통해 회원가입")
    //    @Tag(name = "1-2. [카카오]")
    //    @PostMapping("/oauth/kakao/register")
    //    public AuthResponse registerUser(
    //            @RequestParam("id_token") String token,
    //            @Valid @RequestBody RegisterRequest registerRequest) {
    //        return signUpUseCase.registerUserByOICDToken(token, registerRequest);
    //    }
    //
    //    @Operation(summary = "개발용 회원가입 및 로그인")
    //    @Tag(name = "1-2. [카카오]")
    //    @GetMapping("/oauth/kakao/develop")
    //    public AuthResponse registerUserForTest(@RequestParam String code) {
    //        return signUpUseCase.registerUserByKakaoCode(code);
    //    }
    //
    //    @Operation(summary = "id token 이용해서 로그인")
    //    @Tag(name = "1-2. [카카오]")
    //    @PostMapping("/oauth/kakao/login")
    //    public AuthResponse loginUser(@RequestParam String idToken) {
    //        return loginUseCase.execute(idToken);
    //    }
}
