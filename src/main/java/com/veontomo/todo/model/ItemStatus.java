package com.veontomo.todo.model;

/**
 * Set of statuses of todo items
 * @author Andrew
 *
 */
public enum ItemStatus {
    TODO(0, "to be done"),
    INPROGRESS(1, "in progress"),
    DONE(2, "done"),
    REJECTED(3, "not worth doing");
    
    
    public final String value;
    public final int id;
    
    ItemStatus(int id, String value) {
        this.value = value;
        this.id = id;
    }
       
}
