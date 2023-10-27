package hongik.hmut.domain.domains.group.domain;


import hongik.hmut.domain.domains.AbstractTimeStamp;
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
@Table(name = "tbl_group_user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GroupUser extends AbstractTimeStamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Long groupId;

    @Builder
    public GroupUser(Long userId, Long groupId) {
        this.userId = userId;
        this.groupId = groupId;
    }
}
