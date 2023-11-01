package hongik.hmut.domain.domains.post.adaptor;


import hongik.hmut.core.annotation.Adaptor;
import hongik.hmut.domain.domains.post.domain.Post;
import hongik.hmut.domain.domains.post.exception.PostNotFoundException;
import hongik.hmut.domain.domains.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

@Adaptor
@RequiredArgsConstructor
public class PostAdaptor {

    private final PostRepository postRepository;

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public Post query(Long postId) {
        return postRepository.findById(postId).orElseThrow(() -> PostNotFoundException.EXCEPTION);
    }

    public void delete(Post post) {
        postRepository.delete(post);
    }

    public Slice<Post> search(Pageable pageable, Long groupId) {
        return postRepository.search(pageable, groupId);
    }
}
