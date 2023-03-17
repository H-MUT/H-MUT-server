package hongik.hmut.api.config.security;

import static hongik.hmut.core.consts.StaticVal.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import hongik.hmut.core.dto.ErrorDetail;
import hongik.hmut.core.dto.ErrorResponse;
import hongik.hmut.core.exception.BaseErrorCode;
import hongik.hmut.core.exception.BaseException;
import hongik.hmut.core.exception.GlobalException;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;
import org.springframework.util.PatternMatchUtils;
import org.springframework.web.filter.OncePerRequestFilter;

@RequiredArgsConstructor
@Component
public class AccessDeniedFilter extends OncePerRequestFilter {

    private final ObjectMapper objectMapper;

    @Override
    protected boolean shouldNotFilter(HttpServletRequest req) {
        String servletPath = req.getServletPath();
        return PatternMatchUtils.simpleMatch(SwaggerPatterns, servletPath);
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (BaseException e) {
            exceptionHandle(response, getErrorResponse(e.getErrorCode()));
        } catch (AccessDeniedException e) {
            ErrorResponse access_denied =
                    new ErrorResponse(
                            GlobalException.NOT_VALID_ACCESS_TOKEN_ERROR.getErrorDetail());
            exceptionHandle(response, access_denied);
        }
    }

    private ErrorResponse getErrorResponse(BaseErrorCode errorCode) {
        ErrorDetail errorDetail = errorCode.getErrorDetail();
        return new ErrorResponse(errorDetail);
    }

    private void exceptionHandle(HttpServletResponse response, ErrorResponse errorResponse)
            throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(errorResponse.getStatusCode());
        response.getWriter().write(objectMapper.writeValueAsString(errorResponse));
    }
}
