package com.veontomo.todo.model;

/**
 * Set of statuses of todo items
 * @author Andrew
 *
 */
public enum ItemStatus {
    TODO("to be done"),
    INPROGRESS("in progress");
    
    public final String value;
    
    ItemStatus(String value) {
        this.value = value;
    }
       
}
