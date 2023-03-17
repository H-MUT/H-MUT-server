package hongik.hmut.domain.domains;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;
import javax.annotation.processing.Generated;

/** QAbstractTimeStamp is a Querydsl query type for AbstractTimeStamp */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QAbstractTimeStamp extends EntityPathBase<AbstractTimeStamp> {

    private static final long serialVersionUID = -1709239895L;

    public static final QAbstractTimeStamp abstractTimeStamp =
            new QAbstractTimeStamp("abstractTimeStamp");

    public final DateTimePath<java.sql.Timestamp> createdAt =
            createDateTime("createdAt", java.sql.Timestamp.class);

    public final DateTimePath<java.sql.Timestamp> updatedAt =
            createDateTime("updatedAt", java.sql.Timestamp.class);

    public QAbstractTimeStamp(String variable) {
        super(AbstractTimeStamp.class, forVariable(variable));
    }

    public QAbstractTimeStamp(Path<? extends AbstractTimeStamp> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAbstractTimeStamp(PathMetadata metadata) {
        super(AbstractTimeStamp.class, metadata);
    }
}
