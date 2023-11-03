package hongik.hmut.domain.domains.group.domain;


import hongik.hmut.domain.domains.AbstractTimeStamp;
import hongik.hmut.domain.domains.user.domain.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
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

    @NotNull
    @Enumerated(EnumType.STRING)
    private GroupFrequency groupFrequency;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adminUserId")
    private User adminUser;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Group.TagValue tagValue;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<GroupUser> groupUsers = new ArrayList<>();

    @Getter
    @AllArgsConstructor
    public enum GroupFrequency {
        DAILY("매일"),
        ONCE_A_WEEK("주 1회"),
        TWICE_A_WEEK("주 2회"),
        ONCE_A_MONTH("달 1회"),
        ;

        final String kor;
    }

    @Getter
    @AllArgsConstructor
    public enum TagValue {
        HEALTH("헬스"),
        PILATES("필라테스"),
        CLIMBING("클라이밍"),
        YOGA("요가"),
        RUNNING("런닝"),
        SWIMMING("수영"),
        CYCLE("싸이클"),
        ;
        final String value;
    }

    @Builder
    public Group(
            String groupName,
            String introduceMessage,
            String description,
            String groupImageUrl,
            TagValue tagValue,
            GroupFrequency groupFrequency,
            User adminUser) {
        this.groupName = groupName;
        this.introduceMessage = introduceMessage;
        this.description = description;
        this.groupImageUrl = groupImageUrl;
        this.adminUser = adminUser;
        this.tagValue = tagValue;
        this.groupFrequency = groupFrequency;
    }

    public void update(
            String groupName,
            String introduceMessage,
            String description,
            String groupImageUrl,
            TagValue tagValue,
            GroupFrequency groupFrequency,
            User adminUser) {
        this.groupName = groupName;
        this.introduceMessage = introduceMessage;
        this.description = description;
        this.groupImageUrl = groupImageUrl;
        this.adminUser = adminUser;
        this.tagValue = tagValue;
        this.groupFrequency = groupFrequency;
    }
}
