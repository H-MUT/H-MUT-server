package hongik.hmut.domain.domains.post.repository;


import hongik.hmut.domain.domains.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long>, PostCustomRepository {}
