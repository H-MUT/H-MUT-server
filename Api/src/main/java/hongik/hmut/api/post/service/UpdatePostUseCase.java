package hongik.hmut.api.post.service;


import hongik.hmut.api.config.security.SecurityUtils;
import hongik.hmut.api.post.model.request.UpsertPostRequest;
import hongik.hmut.core.annotation.UseCase;
import hongik.hmut.domain.domains.post.adaptor.PostAdaptor;
import hongik.hmut.domain.domains.post.domain.Post;
import hongik.hmut.domain.domains.post.domain.PostImage;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class UpdatePostUseCase {

    private final PostAdaptor postAdaptor;

    public void execute(Long groupId, Long postId, UpsertPostRequest body) {
        Long currentUserId = SecurityUtils.getCurrentUserId();

        Post post = postAdaptor.query(postId);

        post.update(body.getTitle(), body.getContents(), getPostImages(post, body.getImages()));
    }

    private List<PostImage> getPostImages(Post post, List<String> images) {
        return images.stream()
                .map(image -> PostImage.builder().imageUrl(image).postId(post.getId()).build())
                .toList();
    }
}
