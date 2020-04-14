package org.raccoon.com.jwt.job.repository;

import java.util.Optional;

import org.raccoon.com.jwt.job.domain.JobTodo;
import org.springframework.data.repository.CrudRepository;

public interface JobTodoRepository extends CrudRepository<JobTodo,String>{
    Optional<JobTodo> findByUid(String uid);
}