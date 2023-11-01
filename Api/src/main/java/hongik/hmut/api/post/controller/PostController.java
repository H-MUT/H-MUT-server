package hongik.hmut.api.post.controller;


import hongik.hmut.api.post.model.request.UpsertPostRequest;
import hongik.hmut.api.post.service.CreatePostUseCase;
import hongik.hmut.api.post.service.DeletePostUseCase;
import hongik.hmut.api.post.service.RetrievePostUseCase;
import hongik.hmut.api.post.service.UpdatePostUseCase;
import hongik.hmut.common.SliceResponse;
import hongik.hmut.domain.domains.post.vo.PostDetailInfoVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SecurityRequirement(name = "access-token")
@RestController
@RequestMapping("/groups/{groupId}/posts")
@RequiredArgsConstructor
@Tag(name = "3 [게시글]")
public class PostController {

    private final CreatePostUseCase createPostUseCase;
    private final DeletePostUseCase deletePostUseCase;
    private final RetrievePostUseCase retrievePostUseCase;
    private final UpdatePostUseCase updatePostUseCase;

    @Operation(summary = "게시글 생성")
    @PostMapping
    public void postFeed(@PathVariable Long groupId, @RequestBody @Valid UpsertPostRequest body) {
        createPostUseCase.execute(groupId, body);
    }

    @Operation(summary = "게시글 삭제")
    @DeleteMapping("/{postId}")
    public void deleteFeed(@PathVariable Long groupId, @PathVariable Long postId) {
        deletePostUseCase.execute(groupId, postId);
    }

    @Operation(summary = "게시글 조회")
    @GetMapping
    public SliceResponse<PostDetailInfoVo> getFeeds(
            @PageableDefault Pageable pageable, @PathVariable Long groupId) {
        return SliceResponse.from(retrievePostUseCase.executeOfSlice(pageable, groupId));
    }

    @Operation(summary = "게시글 단건 조회")
    @GetMapping("/{postId}")
    public PostDetailInfoVo getFeed(@PathVariable Long groupId, @PathVariable Long postId) {
        return retrievePostUseCase.execute(postId);
    }

    @Operation(summary = "게시글 수정")
    @PatchMapping("/{postId}")
    public void patchFeed(
            @PathVariable Long groupId,
            @PathVariable Long postId,
            @RequestBody @Valid UpsertPostRequest body) {
        updatePostUseCase.execute(groupId, postId, body);
    }
}
