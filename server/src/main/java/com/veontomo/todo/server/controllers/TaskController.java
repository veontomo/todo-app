package com.veontomo.todo.server.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.veontomo.todo.server.presistence.StatusRepository;

@RestController
public class TaskController {

    private static Logger logger = LoggerFactory.getLogger(TaskController.class);

    final StatusRepository statusRepository;

    @Autowired
    public TaskController(StatusRepository statusRepo) {
        logger.info("Task controller");
        logger.info("count: " + statusRepo.count());
        this.statusRepository = statusRepo;

    }

}
