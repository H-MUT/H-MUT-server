package hongik.hmut.infrastructure.outer.api.oauth.dto;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import feign.Response;
import hongik.hmut.infrastructure.exception.FeignException;
import java.io.IOException;
import java.io.InputStream;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonNaming(SnakeCaseStrategy.class)
public class KakaoAuthErrorResponse {

    private String error;
    private String errorCode;
    private String errorDescription;

    public static KakaoAuthErrorResponse from(Response res) {
        try (InputStream bodyIs = res.body().asInputStream()) {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(bodyIs, KakaoAuthErrorResponse.class);
        } catch (IOException e) {
            throw FeignException.EXCEPTION;
        }
    }
}
