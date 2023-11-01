package hongik.hmut.domain.domains.post.domain;


import hongik.hmut.domain.domains.AbstractTimeStamp;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "tbl_post")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends AbstractTimeStamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull private Long groupId;

    @NotNull private Long userId;

    @NotNull private String title;

    @NotNull private String content;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<PostImage> images = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<PostLike> likes = new ArrayList<>();

    @Builder
    public Post(Long groupId, Long userId, String title, String content) {
        this.groupId = groupId;
        this.userId = userId;
        this.title = title;
        this.content = content;
    }

    public void savePostImages(List<PostImage> postImages) {
        this.images.clear();
        this.images.addAll(postImages);
    }

    public void update(String title, String content, List<PostImage> images) {
        this.title = title;
        this.content = content;
        savePostImages(images);
    }
}
