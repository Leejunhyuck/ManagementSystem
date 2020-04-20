package org.raccoon.com.jwt.board.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@Entity
@Table(name = "webreplies")
@EqualsAndHashCode(of = "rno")
@ToString(exclude = "board")
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    private String replyText;

    private String replyer;

    @CreationTimestamp
    private Timestamp regdate;

    @UpdateTimestamp
    private Timestamp updatedate;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;

    @Builder
    Reply(String replyText, String replyer, Board board) {
        this.replyText = replyText;
        this.replyer = replyer;
        this.board = board;
    }

    public void modifyReply (String replyText, String replyer){
        this.replyText = replyText;
        this.replyer = replyer;
    }
}