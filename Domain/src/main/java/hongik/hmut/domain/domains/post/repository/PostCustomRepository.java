package hongik.hmut.domain.domains.post.repository;


import hongik.hmut.domain.domains.post.domain.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface PostCustomRepository {

    Slice<Post> search(Pageable pageable, Long groupId);
}
