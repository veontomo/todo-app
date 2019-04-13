package com.veontomo.todo.controllers;

import java.security.Principal;
import java.sql.Date;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.veontomo.todo.model.Item;
import com.veontomo.todo.model.ItemStatus;
import com.veontomo.todo.model.TaskDTO;
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
    public ModelAndView newItemPage(@ModelAttribute Item item, Principal principal, ModelMap params) {
        if (principal != null) {
            params.addAttribute("userName", principal.getName());
        }
        params.addAttribute("statuses", ItemStatus.values());
        return new ModelAndView("items/new");
    }

    @PostMapping("/create")
    public ModelAndView create(@Valid TaskDTO taskDto, BindingResult result, RedirectAttributes redirect, Principal principal) {
        if (result.hasErrors()) {
            return new ModelAndView("items/new", "formErrors", result.getAllErrors());
        }

        final Item task = this.convertToTask(taskDto);
        task.setOwner(principal.getName());
        task.setCreatedTime(new Date(System.currentTimeMillis()));
        repo.save(task);

        return new ModelAndView("redirect:/items");
    }

    /**
     * Convert a task dto into a task instance
     * @param taskDto
     * @param userName name of the owner
     * @param createdDate Date when the instance 
     * @return
     */
    private Item convertToTask(TaskDTO taskDto) {
        if (taskDto != null) {
            final ItemStatus rawStatus = ItemStatus.getById(taskDto.getStatus());
            final ItemStatus status = rawStatus != null ? rawStatus : ItemStatus.TODO;
            final Long dueTms = taskDto.getDueDate();
            final Date dueDate = dueTms != null ? new Date(dueTms) : null;
            return new Item(taskDto.getId(), taskDto.getTitle(), taskDto.getDescription(), status, dueDate, null, null);
        }
        return null;
    }

}
