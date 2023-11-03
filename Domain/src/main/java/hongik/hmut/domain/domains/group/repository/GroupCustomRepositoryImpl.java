package hongik.hmut.domain.domains.group.repository;

import static hongik.hmut.domain.domains.group.domain.QGroup.group;
import static hongik.hmut.domain.domains.group.domain.QGroupUser.groupUser;
import static hongik.hmut.domain.domains.user.domain.QUser.user;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import hongik.hmut.domain.common.SliceUtil;
import hongik.hmut.domain.domains.group.condition.GroupSearchCondition;
import hongik.hmut.domain.domains.group.domain.Group;
import hongik.hmut.domain.domains.group.domain.Group.TagValue;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

@RequiredArgsConstructor
public class GroupCustomRepositoryImpl implements GroupCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Slice<Group> search(Pageable pageable, GroupSearchCondition condition) {
        List<Group> contents =
                jpaQueryFactory
                        .selectFrom(group)
                        .leftJoin(group.groupUsers, groupUser)
                        .leftJoin(group.adminUser, user)
                        .fetchJoin()
                        .where(
                                tagEq(condition.getTagValues()),
                                groupNameContains(condition.getGroupName()))
                        .orderBy(group.id.desc())
                        .offset(pageable.getOffset())
                        .limit(pageable.getPageSize() + 1)
                        .fetch();

        return SliceUtil.valueOf(contents, pageable);
    }

    private BooleanExpression tagEq(List<TagValue> tagValues) {
        return (tagValues != null && !tagValues.isEmpty()) ? group.tagValue.in(tagValues) : null;
    }

    private BooleanExpression groupNameContains(String groupName) {
        return (groupName != null) ? group.groupName.contains(groupName) : null;
    }
}
