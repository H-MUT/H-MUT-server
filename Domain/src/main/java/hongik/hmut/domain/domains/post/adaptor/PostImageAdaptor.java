package hongik.hmut.domain.domains.post.adaptor;


import hongik.hmut.core.annotation.Adaptor;
import hongik.hmut.domain.domains.post.repository.PostImageRepository;
import lombok.RequiredArgsConstructor;

@Adaptor
@RequiredArgsConstructor
public class PostImageAdaptor {

    private final PostImageRepository postImageRepository;
}
