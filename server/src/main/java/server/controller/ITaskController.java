package server.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.veontomo.todo.model.Task;

/**
 * API for task operations (CRUD)
 * @author Andrew
 *
 */
public interface ITaskController {
    /**
     * Get a list of all tasks of a user with given name.
     * In case non tasks are present, an empty list should be returned.
     * 
     * @param username
     * @return
     */
    @GetMapping("")
    public List<Task> getTasks(String username);

    /**
     * Save a task assigned to a given user.
     * 
     * The task to create and the user must have the same username. 
     *  
     * @param username
     * @param task
     * @return a newly save task
     */
    @PostMapping("/create")
    public Task save(String username, Task task);

    /**
     * Delete a task with given id. The task should belong to a user with given username. 
     * 
     * @param username
     * @param task
     * @return the deleted task or null if no task was found
     */
    @DeleteMapping("/delete/{id}")
    public Task deleteUserTask(String username, @PathVariable Long id);

}
