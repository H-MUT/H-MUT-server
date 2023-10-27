package hongik.hmut.domain.domains.group.repository;

import static hongik.hmut.domain.domains.group.domain.QGroup.group;
import static hongik.hmut.domain.domains.tag.domain.QTag.tag;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import hongik.hmut.domain.common.SliceUtil;
import hongik.hmut.domain.domains.group.domain.Group;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

@RequiredArgsConstructor
public class GroupCustomRepositoryImpl implements GroupCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Slice<Group> search(Pageable pageable, String tagCondition) {
        List<Group> contents =
                jpaQueryFactory
                        .selectFrom(group)
                        .leftJoin(group.tags, tag)
                        .fetchJoin()
                        .where(tagEq(tagCondition))
                        .orderBy(group.id.desc())
                        .offset(pageable.getOffset())
                        .limit(pageable.getPageSize() + 1)
                        .fetch();

        return SliceUtil.valueOf(contents, pageable);
    }

    private BooleanExpression tagEq(String tagCondition) {
        return (tagCondition != null) ? tag.value.eq(tagCondition) : null;
    }
}
