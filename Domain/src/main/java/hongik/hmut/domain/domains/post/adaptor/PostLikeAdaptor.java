package hongik.hmut.domain.domains.post.adaptor;


import hongik.hmut.core.annotation.Adaptor;
import hongik.hmut.domain.domains.post.repository.PostLikeRepository;
import lombok.RequiredArgsConstructor;

@Adaptor
@RequiredArgsConstructor
public class PostLikeAdaptor {

    private final PostLikeRepository postLikeRepository;
}
