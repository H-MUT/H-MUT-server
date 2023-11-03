package hongik.hmut.domain.domains.tag.domain;


import hongik.hmut.domain.domains.AbstractTimeStamp;
import hongik.hmut.domain.domains.group.domain.Group.TagValue;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "tbl_tag")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Tag extends AbstractTimeStamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NotNull
    private TagValue tagValue;
}
