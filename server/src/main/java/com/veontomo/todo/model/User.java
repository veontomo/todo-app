package com.veontomo.todo.model;

/**
 * A POJO for representing a user
 * @author Andrew
 *
 */
public class User {
    /**
     * user's id
     */
    private Long id;
    /**
     * user's name
     */
    private String name;

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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}
