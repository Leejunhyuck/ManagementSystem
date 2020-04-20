package org.raccoon.com.jwt.board.controller.v1;

import java.util.List;

import javax.transaction.Transactional;

import org.raccoon.com.jwt.board.domain.Board;
import org.raccoon.com.jwt.board.domain.Reply;
import org.raccoon.com.jwt.board.dto.ReplyDto;
import org.raccoon.com.jwt.board.repository.BoardRepository;
import org.raccoon.com.jwt.board.repository.ReplyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@RestController
@RequestMapping("api/replies/*")
@RequiredArgsConstructor
@CrossOrigin
@Log
public class ReplyController {
    private final ReplyRepository replyRepo;
    private final BoardRepository boardRepo;

    @GetMapping
    public ResponseEntity<List<Reply>> getReplies(@PathVariable("bno") Long bno){
        
        log.info("get All Replies..........................");
		
        Board board = Board.builder()
                        .bno(bno)
                        .build();
        
		return new ResponseEntity<>(getListByBoard(board),HttpStatus.OK );

    }

    @Transactional
	@PostMapping("/{bno}")
    public ResponseEntity<List<Reply>> addReply(@PathVariable("bno") Long bno, @RequestBody ReplyDto replyDto){

        log.info("addReply..........................");
		log.info("BNO: " + bno);
		log.info("REPLY: " + replyDto);
		
        Board board = Board.builder()
                        .bno(bno)
                        .build();
                        
        Reply reply = Reply.builder()
                        .board(board)
                        .build();
		
		replyRepo.save(reply);		
		
		return new ResponseEntity<>(getListByBoard(board), HttpStatus.OK);

    }

    @Transactional
	@DeleteMapping("/{bno}/{rno}")
	public ResponseEntity<List<Reply>> remove(
			@PathVariable("bno")Long bno,
			@PathVariable("rno")Long rno){
		
		log.info("delete reply: "+ rno);
		
		replyRepo.deleteById(rno);
        
        Board board = Board.builder()
                        .bno(bno)
                        .build();
		
		return  new ResponseEntity<>(getListByBoard(board), HttpStatus.OK);
		
    }
    
    @Transactional
	@PutMapping("/{bno}")
	public ResponseEntity<List<Reply>> modify(@PathVariable("bno")Long bno, 
        @RequestBody ReplyDto replyDto){
	
		log.info("modify reply: "+ replyDto);
		
		replyRepo.findById(replyDto.getRno()).ifPresent(origin -> {
            origin.modifyReply(replyDto.getReplyText(),replyDto.getReplyer());
			replyRepo.save(origin);
		});
		
        Board board = Board.builder()
                        .bno(bno)
                        .build();
		
		return new ResponseEntity<>(getListByBoard(board), HttpStatus.OK);
	}

    private List<Reply> getListByBoard(Board board)throws RuntimeException{
		
		log.info("getListByBoard...." + board);
		return replyRepo.getRepliesOfBoard(board);
		
    }
    

}