package hongik.hmut.domain.domains.post.exception;

import static hongik.hmut.core.consts.StaticVal.BAD_REQUEST;
import static hongik.hmut.core.consts.StaticVal.NOT_FOUND;

import hongik.hmut.core.consts.StaticVal;
import hongik.hmut.core.dto.ErrorDetail;
import hongik.hmut.core.exception.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PostException implements BaseErrorCode {

    POST_NOT_FOUND_ERROR(NOT_FOUND, "Post_404_1", "게시글 정보를 찾을 수 없습니다."),
    POST_WRITER_NOT_MATCHED_ERROR(BAD_REQUEST, "Post_400_1", "게시글을 작성한 유저가 아닙니다."),
    ;

    private final Integer statusCode;
    private final String errorCode;
    private final String reason;

    @Override
    public ErrorDetail getErrorDetail() {
        return null;
    }
}
