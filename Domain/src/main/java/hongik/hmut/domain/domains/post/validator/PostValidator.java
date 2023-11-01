package hongik.hmut.domain.domains.post.validator;


import hongik.hmut.core.annotation.Validator;
import hongik.hmut.domain.domains.post.adaptor.PostAdaptor;
import hongik.hmut.domain.domains.post.domain.Post;
import hongik.hmut.domain.domains.post.exception.PostWriterNotMatchedException;
import lombok.RequiredArgsConstructor;

@Validator
@RequiredArgsConstructor
public class PostValidator {

    private final PostAdaptor postAdaptor;

    public void validatePostWriter(Post post, Long currentUserId) {
        if (!post.getUserId().equals(currentUserId)) {
            throw PostWriterNotMatchedException.EXCEPTION;
        }
    }
}
