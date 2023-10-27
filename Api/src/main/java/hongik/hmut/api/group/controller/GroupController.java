package hongik.hmut.api.group.controller;


import hongik.hmut.api.group.model.request.UpsertGroupRequest;
import hongik.hmut.api.group.model.response.RetrieveGroupResponse;
import hongik.hmut.api.group.service.CreateGroupUseCase;
import hongik.hmut.api.group.service.DeleteGroupUseCase;
import hongik.hmut.api.group.service.JoinGroupUseCase;
import hongik.hmut.api.group.service.RetrieveGroupUseCase;
import hongik.hmut.api.group.service.RetrieveGroupsUseCase;
import hongik.hmut.api.group.service.UpdateGroupInfoUseCase;
import hongik.hmut.common.SliceResponse;
import hongik.hmut.domain.domains.group.vo.GroupInfoVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SecurityRequirement(name = "access-token")
@RestController
@RequestMapping("/groups")
@RequiredArgsConstructor
@Tag(name = "2 [그룹]")
public class GroupController {

    private final RetrieveGroupsUseCase retrieveGroupsUseCase;
    private final RetrieveGroupUseCase retrieveGroupUseCase;
    private final CreateGroupUseCase createGroupUseCase;
    private final UpdateGroupInfoUseCase updateGroupInfoUseCase;
    private final DeleteGroupUseCase deleteGroupUseCase;
    private final JoinGroupUseCase joinGroupUseCase;

    @Operation(summary = "그룹 탐색")
    @GetMapping
    public SliceResponse<GroupInfoVo> getGroups(
            @PageableDefault Pageable pageable, @RequestParam(required = false) String tag) {
        return SliceResponse.from(retrieveGroupsUseCase.execute(pageable, tag));
    }

    @Operation(summary = "그룹 상세 조회")
    @GetMapping("/{groupId}")
    public RetrieveGroupResponse getGroup(@PathVariable Long groupId) {
        return new RetrieveGroupResponse(retrieveGroupUseCase.execute(groupId));
    }

    @Operation(summary = "그룹 생성")
    @PostMapping
    public void postGroup(@RequestBody @Valid UpsertGroupRequest body) {
        createGroupUseCase.execute(body);
    }

    @Operation(summary = "그룹 정보 수정")
    @PutMapping("/{groupId}")
    public void putGroup(@RequestBody @Valid UpsertGroupRequest body, @PathVariable Long groupId) {
        updateGroupInfoUseCase.execute(body, groupId);
    }

    @Operation(summary = "그룹 삭제")
    @DeleteMapping("/{groupId}")
    public void deleteGroup(@PathVariable Long groupId) {
        deleteGroupUseCase.execute(groupId);
    }

    @Operation(summary = "그룹 참여")
    @PostMapping("/{groupId}/users")
    public void postGroupUser(@PathVariable Long groupId) {
        joinGroupUseCase.execute(groupId);
    }
}
