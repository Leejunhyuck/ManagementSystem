package org.raccoon.com.jwt.board.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReplyDto {
    private Long rno;
    private String replyText;
    private String replyer;


}