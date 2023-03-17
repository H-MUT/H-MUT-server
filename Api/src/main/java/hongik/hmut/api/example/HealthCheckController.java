package hongik.hmut.api.example;


import hongik.hmut.core.exception.InternalServerException;
import io.swagger.v3.oas.annotations.Operation;
import java.util.Objects;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/health")
public class HealthCheckController {

    @Operation(summary = "테스트용 컨트롤러입니다.")
    @GetMapping
    public String healthCheck(@RequestParam String check) {
        if (Objects.equals(check, "error")) {
            throw InternalServerException.EXCEPTION;
        }
        return "Health!";
    }
}
