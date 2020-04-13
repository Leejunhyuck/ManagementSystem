package org.raccoon.com.jwt.job.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@Table(name = "jobtodo")
@EqualsAndHashCode(of = "jid")
@ToString
public class JobTodo {
    @Id
    private String jid;

    @CreationTimestamp
    private Timestamp workDate;

    private String startTime;
    
    private String endTime;

    private String workContent;

}