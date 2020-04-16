package org.raccoon.com.jwt.board.repository;

import org.raccoon.com.jwt.board.domain.Board;
import org.raccoon.com.jwt.board.domain.QBoard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

@Repository
public interface BoardRepository extends CrudRepository<Board, Long>, QuerydslPredicateExecutor<Board> {

	public default Predicate makePredicate(String type, String keyword) {

		BooleanBuilder builder = new BooleanBuilder();

		QBoard qboard = QBoard.board;

		// bno 값이 0보다 큰 값을 가지고 오도록 조건 추가
		builder.and(qboard.bno.gt(0));

		if (type == null) {
			return builder;
		}

		switch (type) {
			case "t":
				builder.and(qboard.tilte.like("%" + keyword + "%"));
				break;
			case "c":
				builder.and(qboard.content.like("%" + keyword + "%"));
				break;
			case "w":
				builder.and(qboard.writer.like("%" + keyword + "%"));
				break;
		}

		return builder;
	}
}