package hongik.hmut.api.post.service;


import hongik.hmut.api.config.security.SecurityUtils;
import hongik.hmut.core.annotation.UseCase;
import hongik.hmut.domain.domains.post.adaptor.PostAdaptor;
import hongik.hmut.domain.domains.post.domain.Post;
import hongik.hmut.domain.domains.post.validator.PostValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class DeletePostUseCase {

    private final PostAdaptor postAdaptor;
    private final PostValidator postValidator;

    public void execute(Long groupId, Long postId) {
        Long currentUserId = SecurityUtils.getCurrentUserId();

        Post post = postAdaptor.query(postId);

        postValidator.validatePostWriter(post, currentUserId);

        postAdaptor.delete(post);
    }
}
