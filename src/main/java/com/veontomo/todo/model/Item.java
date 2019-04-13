package com.veontomo.todo.model;

import java.sql.Date;

/**
 * A mutable ADT for representing a todo item.
 * @author Andrew
 *
 */
public class Item {

    /**
     * task's id
     */
    private Long id;

    /**
     * Short description
     */
    private String title;

    /**
     * Full description
     */
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

    /**
     * owner of the task
     */
    private User owner;

    public Item(Long id, String title, String description, ItemStatus status, Date dueDate, User owner) {
        super();
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.dueDate = dueDate;
        this.owner = owner;
        this.setCreatedTime(new Date(System.currentTimeMillis()));
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
     * @return the owner
     */
    public User getOwner() {
        return owner;
    }

    /**
     * @param owner the owner to set
     */
    public void setOwner(User owner) {
        this.owner = owner;
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
