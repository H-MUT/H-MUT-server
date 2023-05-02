package hongik.hmut.api.auth.controller;

import hongik.hmut.api.auth.model.response.KakaoLoginResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(value = "/auth")
@RequiredArgsConstructor
public class AuthController {

    @GetMapping("/oauth/kakao/dev")
    public KakaoLoginResponse getKakaoLoginLink() {
        return
    }
}
