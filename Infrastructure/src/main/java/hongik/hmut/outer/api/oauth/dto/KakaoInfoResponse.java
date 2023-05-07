package hongik.hmut.outer.api.oauth.dto;


import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonNaming(SnakeCaseStrategy.class)
public class KakaoInfoResponse {

    private Properties properties;
    private String id;
    private KakaoAccount kakaoAccount;

    @Getter
    @NoArgsConstructor
    @JsonNaming(SnakeCaseStrategy.class)
    public static class Properties {
        private String nickName;
    }

    @Getter
    @NoArgsConstructor
    @JsonNaming(SnakeCaseStrategy.class)
    public static class KakaoAccount {

        private Profile profile;
        private String email;
        private String phoneNumber;
        private String name;

        @Getter
        @NoArgsConstructor
        @JsonNaming(SnakeCaseStrategy.class)
        public static class Profile {
            private String profileImageUrl;
        }

        public String getProfileImageUrl() {
            return profile.getProfileImageUrl();
        }
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return kakaoAccount.getEmail();
    }

    public String getPhoneNum() {
        return kakaoAccount.getPhoneNumber();
    }

    public String getName() {
        return kakaoAccount.getName();
    }

    public String getProfileUrl() {
        return kakaoAccount.getProfileImageUrl();
    }
    ;
}
