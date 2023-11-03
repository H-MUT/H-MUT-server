package hongik.hmut.api.auth.model.request;


import hongik.hmut.domain.domains.user.domain.Profile;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RegisterRequest {

    @Email
    @NotEmpty private String email;
    private String profileImage;
    @NotEmpty private String name;

    public Profile toProfile() {
        return Profile.builder().profileImage(this.profileImage).userName(name).email(email).build();
    }
}
