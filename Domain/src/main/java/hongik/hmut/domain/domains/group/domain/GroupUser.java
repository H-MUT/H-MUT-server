package hongik.hmut.domain.domains.group.domain;


import hongik.hmut.domain.domains.AbstractTimeStamp;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "groupId")
    private Group group;

    @Builder
    public GroupUser(Long userId, Group group) {
        this.userId = userId;
        this.group = group;
    }
}
