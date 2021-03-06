package com.leshik.queueforstudents.api.controller;

import com.leshik.queueforstudents.api.model.Queue;
import com.leshik.queueforstudents.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QueueController {
    private final QueueService queueService;

    @Autowired
    public QueueController(QueueService queueService) {
        this.queueService = queueService;
    }

    @GetMapping("/action")
    public List<Queue> actionOnQueue(String userName) {
        queueService.actionOnQueue(userName);
        return queueService.getAllQueueList();
    }

    @GetMapping("/queue")
    public List<Queue> getQueue() {
        return queueService.getAllQueueList();
    }
}
