package org.raccoon.com.jwt.board.repository;

import java.util.List;

import org.raccoon.com.jwt.board.domain.Board;
import org.raccoon.com.jwt.board.domain.Reply;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyRepository extends CrudRepository<Reply,Long> {
    
    @Query("SELECT r FROM Reply r WHERE r.board = ?1 " +
            " AND r.rno > 0 ORDER BY r.rno ASC")
    public List<Reply> getRepliesOfBoard(Board board);

}