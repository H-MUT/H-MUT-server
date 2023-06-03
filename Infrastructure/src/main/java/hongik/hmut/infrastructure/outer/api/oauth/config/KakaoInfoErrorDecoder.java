package hongik.hmut.infrastructure.outer.api.oauth.config;


import feign.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;
import hongik.hmut.core.exception.OuterServerBadRequestException;
import hongik.hmut.core.exception.OuterServerExpiredTokenException;
import hongik.hmut.core.exception.OuterServerForbiddenException;
import hongik.hmut.core.exception.OuterServerUnauthorizedException;

public class KakaoInfoErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        System.out.println("response.reason() = " + response.reason());
        System.out.println("response.status() = " + response.status());
        System.out.println("response.toString() = " + response.toString());
        if (response.status() >= 400) {
            switch (response.status()) {
                case 401:
                    throw OuterServerUnauthorizedException.EXCEPTION;
                case 403:
                    throw OuterServerForbiddenException.EXCEPTION;
                case 419:
                    throw OuterServerExpiredTokenException.EXCEPTION;
                default:
                    throw OuterServerBadRequestException.EXCEPTION;
            }
        }

        return FeignException.errorStatus(methodKey, response);
    }
}
