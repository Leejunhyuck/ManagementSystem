package org.raccoon.com.jwt.job.domain;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@Table(name = "jobtodo")
@EqualsAndHashCode(of = "jid")
@ToString
@NoArgsConstructor
public class JobTodo {
    @Id
    @GeneratedValue
    private Long jid;

    private String uid;

    @CreationTimestamp
    private Timestamp workDate;

    private String startTime;

    private String endTime;

    private String workContent;

    @Builder
    JobTodo(String uid,String startTime,String endTime,String workContent){
        this.uid=uid;
        this.startTime=startTime;
        this.endTime=endTime;
        this.workContent=workContent;
    }

    public void modifyTodo(String startTime,String endTime,String workContent){
        this.startTime = startTime;
        this.endTime = endTime;
        this.workContent = workContent;
    }
}