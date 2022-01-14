package com.apress.todo.todojms.jms;

import com.apress.todo.todojms.domain.ToDo;
import com.apress.todo.todojms.repository.ToDoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Component
@Slf4j
public class ToDoConsumer {
    private ToDoRepository repository;

    public ToDoConsumer(ToDoRepository repository) {
        this.repository = repository;
    }

    @JmsListener(destination = "${todo.jms.destination}", containerFactory = "jmsFactory")
    public void processToDo(@Valid ToDo toDo){
        log.info("Consumer> " + toDo);
        log.info("ToDo created> " + this.repository.save(toDo));
    }
}
