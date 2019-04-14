package server.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.veontomo.todo.model.Task;

/**
 * API for task operations (CRUD)
 * @author Andrew
 *
 */
public interface ITaskController {

    /**
     * Return a list of all tasks of all users.
     * In case no tasks are present, an empty list should be returned.
     * 
     * Only ADMIN have an access to this endpoint. 
     * @return
     */
    @GetMapping("/tasks/admin")
    @Secured("ADMIN")
    public List<Task> getAll();

    /**
     * Get a list of all tasks of given user.
     * In case non tasks are present, an empty list should be returned.
     * 
     * Only USER have an access to this endpoint.
     * @param principal
     * @return
     */
    @GetMapping("/tasks")
    @Secured("USER")
    public List<Task> getUsersTasks(Principal principal);

    /**
     * Save a task assigned to a given user.
     * 
     * The task to create and the user must have the same username. 
     *  
     * @param principal
     * @param task
     * @return a newly save task
     */
    @PostMapping("/tasks/save")
    @Secured("USER")
    public Task save(Principal principal, Task task);

    /**
     * Delete the task of the user. 
     * 
     * The task to delete and the user must have the same username. 
     * @param principal
     * @param task
     * @return the deleted task or null if no task was found
     */
    @DeleteMapping("/tasks/delete")
    @Secured("USER")
    public Task deleteUserTask(Principal principal, Task task);

    /**
     * Delete the task.
     * 
     * Only ADMIN have an access to this endpoint. 
     * @param task
     * @return the deleted task or null if no task was found
     */
    @DeleteMapping("/tasks/delete")
    @Secured("ADMIN")
    public Task deleteTask(Task task);
}
