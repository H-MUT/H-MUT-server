package hongik.hmut.domain.domains.group.domain;


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
import javax.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "tbl_group")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Group extends AbstractTimeStamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull private String groupName;

    @NotNull
    @Size(max = 30)
    private String introduceMessage;

    @NotNull
    @Size(max = 200)
    private String description;

    private String groupImageUrl;

    @NotNull private Long adminUserId;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Tag> tags = new ArrayList<>();

    @Builder
    public Group(
            String groupName,
            String introduceMessage,
            String description,
            String groupImageUrl,
            Long adminUserId) {
        this.groupName = groupName;
        this.introduceMessage = introduceMessage;
        this.description = description;
        this.groupImageUrl = groupImageUrl;
        this.adminUserId = adminUserId;
    }
}
