package com.leshik.queueforstudents.api.controller;

import com.leshik.queueforstudents.api.model.Queue;
import com.leshik.queueforstudents.service.QueueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Slf4j
public class UpdateController {

    private final QueueService queueService;

    @Autowired
    public UpdateController(QueueService queueService) {
        this.queueService = queueService;
    }

    @MessageMapping("/take")
    @SendTo("/topic/queue")
    public List<Queue> updateQueue(){
        log.error("update queue was calling");
        return queueService.getAllQueueList();
    }
}
