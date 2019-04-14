package com.veontomo.todo.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * A DTO for {@link Task}
 * @author Andrew
 *
 */
public class TaskDTO {
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
    @NotNull
    private int status;

    /**
     * task's creation time stamp 
     */
    private long createdDate;

    /**
     * task's due time stamp
     */
    private Long dueDate;

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
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the createdDate
     */
    public long getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(long createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @return the dueDate
     */
    public Long getDueDate() {
        return dueDate;
    }

    /**
     * @param dueDate the dueDate to set
     */
    public void setDueDate(Long dueDate) {
        this.dueDate = dueDate;
    }

}
