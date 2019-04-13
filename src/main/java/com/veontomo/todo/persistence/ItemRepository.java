package com.veontomo.todo.persistence;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;


public interface ItemRepository {
    /**
     * Retrieve all todo items
     * @return
     */
    Iterable<Item> getAll();

    /**
     * Save the todo item
     * @param item
     * @return
     */
    Item save(Item item);

    /**
     * Retrieve an item by its id. 
     * If no todo item with given id exists, return null.
     * @param id
     * @return
     */
    Item findById(Long id);

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
