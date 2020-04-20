package org.raccoon.com.jwt.board.domain;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Entity
@Table(name= "webboards")
@EqualsAndHashCode(of ="bno")
@ToString
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    private String title;

    private String writer;

    private String content;

    @CreationTimestamp
    private Timestamp regdate;
    
    @UpdateTimestamp
    private Timestamp updatedate;
    
    @OneToMany(mappedBy ="board", fetch =FetchType.LAZY)
    private List<Reply> replies;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="pdsno")
    private List<PDSfile> files;


    @Builder
    Board(Long bno, String title, String writer, String content, List<Reply> replies){
        this.bno = bno;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.replies = replies;
    }

    public void modifyBoard (String title, String writer, String content){
        this.title = title;
        this.content = content;
        this.writer = writer;
    }
    
}