package hongik.hmut.domain.domains.user.domain;


import hongik.hmut.domain.domains.AbstractTimeStamp;
import hongik.hmut.domain.domains.group.domain.Group;
import java.util.List;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "tbl_user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends AbstractTimeStamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded private Profile profile;

    private String tagValues;

    @Builder
    public User(Profile profile, List<Group.TagValue> tagValues) {
        this.profile = profile;
        this.tagValues = tagValues.toString();
    }
}
