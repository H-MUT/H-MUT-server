package hongik.hmut.api.group.model.response;


import hongik.hmut.domain.domains.group.vo.GroupDetailInfoVo;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RetrieveGroupResponse {

    private final GroupDetailInfoVo groupInfo;
}
