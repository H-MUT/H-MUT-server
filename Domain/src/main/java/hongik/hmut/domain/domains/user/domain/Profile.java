package hongik.hmut.domain.domains.user.domain;


import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Profile {

    private String userName;

    private String email;

    private String profileImage;

    @Builder
    public Profile(String userName, String email, String profileImage) {
        this.userName = userName;
        this.email = email;
        this.profileImage = profileImage;
    }
}
