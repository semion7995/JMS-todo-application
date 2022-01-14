package com.apress.todo.todojms.repository;


import com.apress.todo.todojms.domain.ToDo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends CrudRepository<ToDo, String> {

}
