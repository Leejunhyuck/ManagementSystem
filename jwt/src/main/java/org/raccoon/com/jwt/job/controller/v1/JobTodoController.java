package org.raccoon.com.jwt.job.controller.v1;

import org.raccoon.com.jwt.job.domain.JobTodo;
import org.raccoon.com.jwt.job.dto.TodoDto;
import org.raccoon.com.jwt.job.repository.JobTodoRepository;
import org.raccoon.com.jwt.user.dto.ReqDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/jobtodo/*")
@CrossOrigin
@Log
@RequiredArgsConstructor
public class JobTodoController {
    private final JobTodoRepository repo;

    @GetMapping("list")
    public ResponseEntity<JobTodo> getTodo(@RequestBody TodoDto todo) {
        log.info("getTodo ..................." + todo);

        JobTodo jobtodo = repo.findByUid(todo.getUid()).orElseThrow(() -> new IllegalArgumentException("no such data"));
        
        return new ResponseEntity<>(jobtodo, HttpStatus.OK);
    }

    @PostMapping("register")
    public ResponseEntity<JobTodo> regTodo(@RequestBody TodoDto todo) {
        log.info("UpdateTodo......." + todo);

        JobTodo jobtodo = JobTodo.builder().uid(todo.getUid()).startTime(todo.getStartTime()).endTime(todo.getEndTime())
                .workContent(todo.getWorkContent()).build();

        repo.save(jobtodo);

        return new ResponseEntity<>(jobtodo, HttpStatus.CREATED);
    }

    @PostMapping("update")
    public ResponseEntity<JobTodo> updateTodo(@RequestBody TodoDto todo) {
        log.info("updateTodo........."+todo);

        repo.findById(todo.getJid()).ifPresent(origin ->{
            origin.modifyTodo(todo.getStartTime(), todo.getEndTime(), todo.getEndTime());
        
            repo.save(origin);
        });
        
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("delete")
    public ResponseEntity<JobTodo> deleteTodo(@RequestBody TodoDto todo){
        log.info("deleteTodo......."+todo);

        repo.findById(todo.getJid()).ifPresent(origin ->{
            repo.delete(origin);
        });

        return new ResponseEntity<>(HttpStatus.OK);
    }
}