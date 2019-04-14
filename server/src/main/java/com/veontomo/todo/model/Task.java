package com.veontomo.todo.model;

import java.sql.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * A mutable ADT for representing a todo item.
 * @author Andrew
 *
 */
public class Task {

    /**
     * task's id
     */
    private Long id;

    /**
     * Short description
     */
    @NotEmpty(message = "Title is required.")
    @Size(max = 100, message = "Max size is 100 characters.")
    private String title;

    /**
     * Full description
     */
    @Size(max = 1000, message = "Max size is 1000 characters.")
    private String description;

    /**
     * current status
     */

    private ItemStatus status;

    /**
     * time when the item is created 
     */
    private Date createdDate;

    /**
     * time by which the task should be done
     */
    private Date dueDate;

    public Task(Long id, String title, String description, ItemStatus status, Date dueDate, String owner, Date created) {
        super();
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.dueDate = dueDate;
        this.createdDate = created;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the status
     */
    public ItemStatus getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(ItemStatus status) {
        this.status = status;
    }

    /**
     * @return the dueDate
     */
    public Date getDueDate() {
        return dueDate;
    }

    /**
     * @param dueDate the dueDate to set
     */
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * @return the createdDate
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate the createdTime to set
     */
    public void setCreatedTime(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

}
