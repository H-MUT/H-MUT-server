package hongik.hmut.domain.domains.post.domain;


import hongik.hmut.domain.domains.AbstractTimeStamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "tbl_post_image")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostImage extends AbstractTimeStamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull private Long postId;

    @NotNull private String imageUrl;

    @NotNull private Long number;

    @Builder
    public PostImage(Long postId, String imageUrl, Long number) {
        this.postId = postId;
        this.imageUrl = imageUrl;
        this.number = number;
    }
}
