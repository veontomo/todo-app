package com.veontomo.todo.server.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veontomo.todo.model.Task;
import com.veontomo.todo.server.presistence.ItemRepository;

/**
 * Implementation of tasks CRUD operations for user role.
 * @author Andrew
 *
 */
@RestController
@RequestMapping("/api/user")
public class UserTaskController implements ITaskController {

    private final ItemRepository repo;

    private static Logger logger = LoggerFactory.getLogger(UserTaskController.class);

    @Autowired
    public UserTaskController(ItemRepository repo) {
        this.repo = repo;
        logger.info("User task controller is ready.");
    }

    @Override
    public List<Task> getTasks(String username) {
        return repo.getUserTasks(username);
    }

    @Override
    public Task save(String usernamel, Task task) {
        return null;
    }

    @Override
    public Task deleteUserTask(String username, Long id) {
        // TODO Auto-generated method stub
        return null;
    }

}
