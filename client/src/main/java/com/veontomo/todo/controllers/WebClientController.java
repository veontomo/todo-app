package com.veontomo.todo.controllers;

import java.security.Principal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.veontomo.todo.model.ItemStatus;
import com.veontomo.todo.model.Task;
import com.veontomo.todo.model.TaskDTO;

/**
 * Simple client for displaying the todo tasks
 * @author Andrew
 *
 */
@Controller
@RequestMapping("/items")
public class WebClientController {

    @Value("${todo-server.url}")
    private String serverUrl;

    private static Logger logger = LoggerFactory.getLogger(WebClientController.class);

    @RequestMapping
    public ModelAndView list(Principal principal, ModelMap params) {
        logger.info("Principal {}", principal.toString());
        if (principal != null) {
            params.addAttribute("userName", principal.getName());
        }
        RestTemplate restTemplate = new RestTemplate();
        List<Task> tasks = null;
        try {
            ResponseEntity<List<Task>> response = restTemplate.exchange(serverUrl + "/api/user", HttpMethod.GET, null, new ParameterizedTypeReference<List<Task>>() {
            });
            tasks = response.getBody();
        } catch (ResourceAccessException e) {
            logger.error("Failed to connect: {}", e);
            tasks = new ArrayList<Task>(0);
            params.addAttribute("message", "Connection failure");
        }
        params.addAttribute("items", tasks);
        return new ModelAndView("items/list");
    }

    @GetMapping("/new")
    public ModelAndView newItemPage(@ModelAttribute Task item, Principal principal, ModelMap params) {
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

        final Task task = this.convertToTask(taskDto);
        task.setCreatedTime(new Date(System.currentTimeMillis()));
        // repo.save(task);

        return new ModelAndView("redirect:/items");
    }

    /**
     * Convert a task dto into a task instance
     * @param taskDto
     * @param userName name of the owner
     * @param createdDate Date when the instance 
     * @return
     */
    private Task convertToTask(TaskDTO taskDto) {
        if (taskDto != null) {
            final ItemStatus rawStatus = ItemStatus.getById(taskDto.getStatus());
            final ItemStatus status = rawStatus != null ? rawStatus : ItemStatus.TODO;
            final Long dueTms = taskDto.getDueDate();
            final Date dueDate = dueTms != null ? new Date(dueTms) : null;
            return new Task(taskDto.getId(), taskDto.getTitle(), taskDto.getDescription(), status, dueDate, null, null);
        }
        return null;
    }

}
