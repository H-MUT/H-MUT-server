package hongik.hmut.domain.domains.post.adaptor;


import hongik.hmut.core.annotation.Adaptor;
import hongik.hmut.domain.domains.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;

@Adaptor
@RequiredArgsConstructor
public class PostAdaptor {

    private final PostRepository postRepository;
}
