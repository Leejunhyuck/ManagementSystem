package org.raccoon.com.jwt.user.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMemberEnum is a Querydsl query type for MemberEnum
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMemberEnum extends EntityPathBase<MemberEnum> {

    private static final long serialVersionUID = 970373423L;

    public static final QMemberEnum memberEnum = new QMemberEnum("memberEnum");

    public final StringPath password = createString("password");

    public final DateTimePath<java.sql.Timestamp> regdate = createDateTime("regdate", java.sql.Timestamp.class);

    public final ListPath<Role, EnumPath<Role>> roles = this.<Role, EnumPath<Role>>createList("roles", Role.class, EnumPath.class, PathInits.DIRECT2);

    public final StringPath uid = createString("uid");

    public final StringPath uname = createString("uname");

    public final DateTimePath<java.sql.Timestamp> updatedate = createDateTime("updatedate", java.sql.Timestamp.class);

    public QMemberEnum(String variable) {
        super(MemberEnum.class, forVariable(variable));
    }

    public QMemberEnum(Path<? extends MemberEnum> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMemberEnum(PathMetadata metadata) {
        super(MemberEnum.class, metadata);
    }

}

