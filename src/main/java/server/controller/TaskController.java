package server.controller;

import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veontomo.todo.model.Task;
import com.veontomo.todo.persistence.ItemRepository;

/**
 * Implementation of tasks CRUD operations.
 * @author Andrew
 *
 */
@RestController
@RequestMapping("/api")
public class TaskController implements ITaskController {

    private final ItemRepository repo;

    private static Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    public TaskController(ItemRepository repo) {
        this.repo = repo;
        logger.info("Task controller is ready.");
    }

    @Override
    public List<Task> getAll() {
        // stub
        return repo.getAll();
    }

    @Override
    public List<Task> getUsersTasks(Principal principal) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Task save(Principal principal, Task task) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Task deleteUserTask(Principal principal, Task task) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Task deleteTask(Task task) {
        // TODO Auto-generated method stub
        return null;
    }

}
