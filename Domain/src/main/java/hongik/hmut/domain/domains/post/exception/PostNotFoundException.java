package hongik.hmut.domain.domains.post.exception;


import hongik.hmut.core.exception.BaseException;

public class PostNotFoundException extends BaseException {

    public static final BaseException EXCEPTION = new PostNotFoundException();

    private PostNotFoundException() {
        super(PostException.POST_NOT_FOUND_ERROR);
    }
}
