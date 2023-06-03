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

    private String username;

    private String nickname;

    private String email;

    private String thumbNail;

    @Builder
    public Profile(String username, String nickname, String email, String thumbNail) {
        this.nickname = nickname;
        this.username = username;
        this.email = email;
        this.thumbNail = thumbNail;
    }
}
