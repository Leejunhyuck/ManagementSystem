package org.raccoon.com.jwt.user.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = -1757681906L;

    public static final QMember member = new QMember("member1");

    public final StringPath password = createString("password");

    public final DateTimePath<java.sql.Timestamp> regdate = createDateTime("regdate", java.sql.Timestamp.class);

    public final ListPath<MemberRole, QMemberRole> roles = this.<MemberRole, QMemberRole>createList("roles", MemberRole.class, QMemberRole.class, PathInits.DIRECT2);

    public final ListPath<org.raccoon.com.jwt.job.domain.JobTodo, org.raccoon.com.jwt.job.domain.QJobTodo> todo = this.<org.raccoon.com.jwt.job.domain.JobTodo, org.raccoon.com.jwt.job.domain.QJobTodo>createList("todo", org.raccoon.com.jwt.job.domain.JobTodo.class, org.raccoon.com.jwt.job.domain.QJobTodo.class, PathInits.DIRECT2);

    public final StringPath uid = createString("uid");

    public final StringPath uname = createString("uname");

    public final DateTimePath<java.sql.Timestamp> updatedate = createDateTime("updatedate", java.sql.Timestamp.class);

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

