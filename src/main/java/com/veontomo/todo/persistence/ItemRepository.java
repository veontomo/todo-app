package com.veontomo.todo.persistence;

import java.util.List;

import com.veontomo.todo.model.Task;

public interface ItemRepository {
    /**
     * Retrieve all todo items
     * @return
     */
    List<Task> getAll();

    /**
     * Save the todo item
     * @param item
     * @return
     */
    Task save(Task item);

    /**
     * Retrieve an item by its id. 
     * If no todo item with given id exists, return null.
     * @param id
     * @return
     */
    Task findById(Long id);

    /**
     * Delete a todo item with given id. 
     * After this operation, no todo item with the given id should exist.
     * If no item is deleted (because it does not exist), false is returned.
     * If the operation has deleted the item, true is returned. 
     * @param id
     * @return true if the operation has deleted an item, false otherwise
     */
    boolean deleteById(Long id);

}
