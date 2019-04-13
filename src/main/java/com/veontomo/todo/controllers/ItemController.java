package com.veontomo.todo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
public class ItemController {

    private final ItemRepository repo;

    @Autowired
    public ItemController(ItemRepository repo) {
        this.repo = repo;
    }

    @RequestMapping
    public ModelAndView list() {
        final Iterable<Item> items = repo.getAll();
        return new ModelAndView("items/list", "items", items);
    }

    @GetMapping("/new")
    public ModelAndView create(@ModelAttribute Item item) {
        return new ModelAndView("items/new");
    }

}
