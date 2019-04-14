package server.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veontomo.todo.model.Task;

import server.presistence.ItemRepository;

/**
 * Implementation of tasks CRUD operations for admin role.
 * @author Andrew
 *
 */
@RestController
@RequestMapping("/api/admin")
public class AdminTaskController implements ITaskController {

    private final ItemRepository repo;

    private static Logger logger = LoggerFactory.getLogger(AdminTaskController.class);

    @Autowired
    public AdminTaskController(ItemRepository repo) {
        this.repo = repo;
        logger.info("Admin task controller is ready.");
    }

    @Override
    public List<Task> getTasks(String username) {
        // TODO Auto-generated method stub
        return repo.getAll();
    }

    @Override
    public Task save(String username, Task task) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Task deleteUserTask(String username, Long id) {
        // TODO Auto-generated method stub
        return null;
    }

}
