package org.raccoon.com.jwt.job.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QJobTodo is a Querydsl query type for JobTodo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QJobTodo extends EntityPathBase<JobTodo> {

    private static final long serialVersionUID = -873180809L;

    public static final QJobTodo jobTodo = new QJobTodo("jobTodo");

    public final StringPath endTime = createString("endTime");

    public final NumberPath<Long> jid = createNumber("jid", Long.class);

    public final StringPath startTime = createString("startTime");

    public final StringPath uid = createString("uid");

    public final StringPath workContent = createString("workContent");

    public final DateTimePath<java.sql.Timestamp> workDate = createDateTime("workDate", java.sql.Timestamp.class);

    public QJobTodo(String variable) {
        super(JobTodo.class, forVariable(variable));
    }

    public QJobTodo(Path<? extends JobTodo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJobTodo(PathMetadata metadata) {
        super(JobTodo.class, metadata);
    }

}

