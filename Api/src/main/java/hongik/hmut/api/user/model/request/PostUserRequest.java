package hongik.hmut.api.user.model.request;


import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostUserRequest {

    @Schema(description = "", example = "test")
    @NotBlank(message = "그룹 이름을 입력해주세요.")
    private String groupName;
}
