package hongik.hmut.domain.domains.post.vo;

import hongik.hmut.domain.domains.post.domain.Post;
import hongik.hmut.domain.domains.post.domain.PostImage;
import hongik.hmut.domain.domains.post.domain.PostLike;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostDetailInfoVo {

    private final Long postId;

    private final String title;

    private final String content;

    private final List<String> images;

    private final int likeCount;

    private final boolean isLiked;

    public static PostDetailInfoVo of(Post post, Long currentUserId) {
        List<PostLike> likes = post.getLikes();
        return PostDetailInfoVo.builder().postId(post.getId())
            .title(post.getTitle())
            .content(post.getContent())
            .images(post.getImages().stream().map(PostImage::getImageUrl).toList())
            .likeCount(likes.size())
            .isLiked(
                likes.stream().anyMatch(postLike -> postLike.getUserId().equals(currentUserId)))
            .build();
    }
}
