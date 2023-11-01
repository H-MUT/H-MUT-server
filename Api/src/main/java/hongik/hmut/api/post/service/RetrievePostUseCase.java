package hongik.hmut.api.post.service;

import hongik.hmut.api.config.security.SecurityUtils;
import hongik.hmut.core.annotation.UseCase;
import hongik.hmut.domain.domains.group.adaptor.GroupAdaptor;
import hongik.hmut.domain.domains.group.domain.Group;
import hongik.hmut.domain.domains.post.adaptor.PostAdaptor;
import hongik.hmut.domain.domains.post.vo.PostDetailInfoVo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RetrievePostUseCase {

    private final GroupAdaptor groupAdaptor;
    private final PostAdaptor postAdaptor;

    public Slice<PostDetailInfoVo> executeOfSlice(Pageable pageable, Long groupId) {
        Long currentUserId = SecurityUtils.getCurrentUserId();

        Group group = groupAdaptor.query(groupId);

        return postAdaptor.search(pageable, group.getId())
            .map(post -> PostDetailInfoVo.of(post, currentUserId));
    }

    public PostDetailInfoVo execute(Long postId) {
        return PostDetailInfoVo.of(postAdaptor.query(postId), SecurityUtils.getCurrentUserId());
    }
}
