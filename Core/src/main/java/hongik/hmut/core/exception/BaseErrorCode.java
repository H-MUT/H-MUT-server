package hongik.hmut.core.exception;


import hongik.hmut.core.dto.ErrorDetail;

public interface BaseErrorCode {

    public ErrorDetail getErrorDetail();

    //    String getExplainError() throws NoSuchFieldException;
}
