package hongik.hmut.domain.domains.group.exception;

import static hongik.hmut.core.consts.StaticVal.*;

import hongik.hmut.core.dto.ErrorDetail;
import hongik.hmut.core.exception.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GroupException implements BaseErrorCode {
    GROUP_NOT_FOUND_ERROR(NOT_FOUND, "Group_404_1", "그룹 정보를 찾을 수 없습니다."),
    GROUP_ADMIN_NOT_MATCHED_ERROR(UNAUTHORIZED, "Group_401_1", "그룹 어드민 자격이 없습니다."),
    ALREADY_JOIN_GROUP_USER_ERROR(BAD_REQUEST, "Group_400_1", "이미 그룹에 가입된 유저입니다."),
    NOT_JOINED_MEMBER_ERROR(UNAUTHORIZED, "Group_401_2", "그룹에 가입하지 않은 유저입니다."),
    ;

    private final Integer statusCode;
    private final String errorCode;
    private final String reason;

    @Override
    public ErrorDetail getErrorDetail() {
        return ErrorDetail.of(statusCode, errorCode, reason);
    }
}
