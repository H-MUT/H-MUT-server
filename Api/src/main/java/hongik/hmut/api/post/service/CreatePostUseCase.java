package hongik.hmut.api.post.service;

import hongik.hmut.api.config.security.SecurityUtils;
import hongik.hmut.api.post.model.request.UpsertPostRequest;
import hongik.hmut.core.annotation.UseCase;
import hongik.hmut.domain.domains.group.adaptor.GroupAdaptor;
import hongik.hmut.domain.domains.group.domain.Group;
import hongik.hmut.domain.domains.group.validator.GroupValidator;
import hongik.hmut.domain.domains.post.adaptor.PostAdaptor;
import hongik.hmut.domain.domains.post.domain.Post;
import hongik.hmut.domain.domains.post.domain.PostImage;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class CreatePostUseCase {

    private final PostAdaptor postAdaptor;
    private final GroupAdaptor groupAdaptor;
    private final GroupValidator groupValidator;

    public void execute(Long groupId, UpsertPostRequest body) {
        Long currentUserId = SecurityUtils.getCurrentUserId();
        Group group = groupAdaptor.query(groupId);

        groupValidator.validateNotJoinGroup(group, currentUserId);

        Post post = Post.builder().userId(currentUserId).groupId(groupId)
            .title(body.getTitle())
            .content(body.getContents())
            .build();
        Post savePost = postAdaptor.save(post);

        savePostImages(savePost, body.getImages());
    }

    private void savePostImages(Post post, List<String> images) {
        post.savePostImages(images.stream()
            .map(image -> PostImage.builder().postId(post.getId()).imageUrl(image).build())
            .toList());
    }
}
