package com.veontomo.todo.controllers;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
    
    private static Logger logger = LoggerFactory.getLogger(ItemController.class);


    @Autowired
    public ItemController(ItemRepository repo) {
        this.repo = repo;
    }

    @RequestMapping
    public ModelAndView list(Principal principal, ModelMap params) {
        logger.info("Principal {}", principal.toString());
        final Iterable<Item> items = repo.getAll();
        params.addAttribute("items", items);
        if (principal != null) {
            params.addAttribute("userName", principal.getName());
        }
        return new ModelAndView("items/list");
    }

    @GetMapping("/new")
    public ModelAndView create(@ModelAttribute Item item, Principal principal, ModelMap params) {
        if (principal != null) {
            params.addAttribute("userName", principal.getName());
        }
        return new ModelAndView("items/new");
    }

}
