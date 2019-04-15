package com.veontomo.todo.server.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.veontomo.todo.model.Task;
import com.veontomo.todo.server.presistence.TaskRepository;

@RestController
public class TaskController implements ITaskController {

    private static Logger logger = LoggerFactory.getLogger(TaskController.class);

    final TaskRepository repository;

    @Autowired
    public TaskController(TaskRepository repository) {
        logger.info("Task controller has started.");
        this.repository = repository;
    }

    @Override
    public List<Task> getTasks(String username) {
        return repository.findByUserName(username);
    }

    @Override
    public Task getTask(Long id) {
        final Optional<Task> result = repository.findById(id);
        return result.isPresent() ? result.get() : null;
    }

    @Override
    public Task create(Task task) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Task update(Long id, Task task) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Task delete(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

}
