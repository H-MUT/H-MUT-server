package hongik.hmut.api.group.model.request;


import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpsertGroupRequest {

    @Schema(description = "그룸 이름", example = "test")
    @NotBlank(message = "그룹 이름을 입력해주세요.")
    private String groupName;

    @Schema(description = "그룹 한줄 소개", example = "한 줄 소개")
    @NotBlank(message = "그룹 한줄 소개를 입력해주세요.")
    @Size(max = 30, message = "최대 30자입니다.")
    private String introduceMessage;

    @Schema(description = "그룹 소개", example = "소개글")
    @NotBlank(message = "그룹 소개를 입력해주세요.")
    @Size(max = 200, message = "최대 200자입니다.")
    private String description;

    @Schema(description = "이미지 URL", example = "test.com")
    private String imageUrl;

    @Schema(description = "태그 리스트")
    @NotNull(message = "태그를 적어도 1개 입력해주세요.")
    private List<String> tags;
}
