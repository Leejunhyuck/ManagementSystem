package org.raccoon.com.jwt.job.repository;

import org.raccoon.com.jwt.job.domain.JobTodo;
import org.springframework.data.repository.CrudRepository;

public interface JobTodoRepository extends CrudRepository<JobTodo,String>{

}