package hongik.hmut.infrastructure.outer.api.oauth.config;


import feign.Response;
import feign.codec.ErrorDecoder;
import hongik.hmut.core.dto.ErrorDetail;
import hongik.hmut.core.exception.OuterServerException;
import hongik.hmut.infrastructure.outer.api.oauth.dto.KakaoAuthErrorResponse;
import hongik.hmut.infrastructure.outer.api.oauth.exception.KakaoAuthErrorCode;

public class KakaoAuthErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        KakaoAuthErrorResponse body = KakaoAuthErrorResponse.from(response);

        try {
            KakaoAuthErrorCode kakaoKauthErrorCode =
                    KakaoAuthErrorCode.valueOf(body.getErrorCode());
            ErrorDetail errorDetail = kakaoKauthErrorCode.getErrorDetail();
            throw new OuterServerException(
                    errorDetail.getStatusCode(),
                    errorDetail.getErrorCode(),
                    errorDetail.getReason());
        } catch (IllegalArgumentException e) {
            KakaoAuthErrorCode koeInvalidRequest = KakaoAuthErrorCode.KOE_INVALID_REQUEST;
            ErrorDetail errorDetail = koeInvalidRequest.getErrorDetail();
            throw new OuterServerException(
                    errorDetail.getStatusCode(),
                    errorDetail.getErrorCode(),
                    errorDetail.getReason());
        }
    }
}
