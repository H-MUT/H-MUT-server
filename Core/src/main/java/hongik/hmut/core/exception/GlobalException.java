package hongik.hmut.core.exception;

import static hongik.hmut.core.consts.StaticVal.*;

import hongik.hmut.core.dto.ErrorDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GlobalException implements BaseErrorCode {
    INTERNAL_SERVER_ERROR(SERVER_ERROR, "500-1", "서버 내부 오류입니다."),
    EXPIRED_TOKEN_ERROR(UNAUTHORIZED, "401-1", "토큰이 만료되었습니다."),
    INVALID_TOKEN_ERROR(UNAUTHORIZED, "401-2", "올바르지 않은 토큰입니다."),
    EXPIRED_REFRESH_TOKEN_ERROR(UNAUTHORIZED, "401-3", "리프레시 토큰이 만료되었습니다."),
    NOT_VALID_ACCESS_TOKEN_ERROR(UNAUTHORIZED, "401-4", "토큰의 형식이 잘못되었습니다."),
    SECURITY_CONTEXT_NOT_FOUND_ERROR(500, "500-2", "Security Context 에러입니다.");

    private final Integer statusCode;
    private final String errorCode;
    private final String reason;

    @Override
    public ErrorDetail getErrorDetail() {
        return ErrorDetail.of(statusCode, errorCode, reason);
    }
}
