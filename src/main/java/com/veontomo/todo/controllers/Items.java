package com.veontomo.todo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.veontomo.todo.model.Item;
import com.veontomo.todo.persistence.ItemRepository;
/**
 * CRUD for handling the todo items
 * @author Andrew
 *
 */
@Controller
@RequestMapping("/items")
public class Items {
    
    private final ItemRepository repo;
    
    @Autowired
    public Items(ItemRepository repo) {
        this.repo = repo;
    }
    @RequestMapping
    public ModelAndView list() {
        final Iterable<Item> items = repo.getAll();
        return new ModelAndView("items/list", "items", items);
    }

}
