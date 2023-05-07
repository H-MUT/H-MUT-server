package hongik.hmut.api.auth.model.request;

import hongik.hmut.domain.domains.user.domain.Profile;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RegisterRequest {

    @NotEmpty
    private String email;
    private String phoneNumber;
    private String profileImage;
    @NotEmpty private String name;

    public Profile toProfile() {
        return Profile.builder()
            .thumbNail(this.profileImage)
            .phoneNum(phoneNumber)
            .userName(name)
            .email(email)
            .build();
    }
}
