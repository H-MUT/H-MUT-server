package hongik.hmut.domain.domains.post.exception;

import hongik.hmut.core.exception.BaseException;

public class PostWriterNotMatchedException extends BaseException {

    public static final BaseException EXCEPTION = new PostWriterNotMatchedException();

    private PostWriterNotMatchedException() {
        super(PostException.POST_WRITER_NOT_MATCHED_ERROR);
    }
}
