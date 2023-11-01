package hongik.hmut.api.post.model.request;


import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpsertPostRequest {

    @Schema(description = "게시글 제목")
    @NotBlank(message = "게시글 제목을 입력해주세요.")
    private String title;

    @Schema(description = "게시글 내용")
    @NotBlank(message = "게시글 내용을 입력해주세요.")
    private String contents;

    @Schema(description = "이미지 리스트")
    @NotNull(message = "이미지 리스트를 입력해주세요.")
    private List<String> images;
}
