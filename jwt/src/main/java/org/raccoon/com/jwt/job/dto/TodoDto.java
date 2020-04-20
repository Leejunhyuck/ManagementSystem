package org.raccoon.com.jwt.job.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TodoDto {
    private String uid;
    private String jid;
    private String startTime;
    private String endTime;
    private String workContent;
}