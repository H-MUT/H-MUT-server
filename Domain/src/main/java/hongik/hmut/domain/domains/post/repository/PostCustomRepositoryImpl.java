package hongik.hmut.domain.domains.post.repository;

import static hongik.hmut.domain.domains.post.domain.QPost.post;
import static hongik.hmut.domain.domains.post.domain.QPostLike.postLike;

import com.querydsl.jpa.impl.JPAQueryFactory;
import hongik.hmut.domain.common.SliceUtil;
import hongik.hmut.domain.domains.post.domain.Post;
import hongik.hmut.domain.domains.post.domain.QPost;
import hongik.hmut.domain.domains.post.domain.QPostLike;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

@RequiredArgsConstructor
public class PostCustomRepositoryImpl implements PostCustomRepository{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Slice<Post> search(Pageable pageable, Long groupId) {
        List<Post> contents = jpaQueryFactory.selectFrom(post)
            .leftJoin(post.likes, postLike)
            .fetchJoin()
            .where(post.groupId.eq(groupId))
            .orderBy(post.id.desc())
            .offset(pageable.getOffset())
            .limit(pageable.getPageSize() + 1)
            .fetch();

        return SliceUtil.valueOf(contents, pageable);
    }
}
