package server.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veontomo.todo.model.Task;
import com.veontomo.todo.persistence.ItemRepository;

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
        logger.info("Task controller is ready.");
    }

    @Override
    public List<Task> getTasks(String username) {
        return repo.getAll();
    }

    @Override
    public Task save(String usernamel, Task task) {
        return null;
    }

}
