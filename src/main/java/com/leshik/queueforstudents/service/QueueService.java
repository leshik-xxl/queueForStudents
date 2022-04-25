package com.leshik.queueforstudents.service;

import com.leshik.queueforstudents.api.model.Queue;

import java.util.List;

public interface QueueService {
    List<Queue> getAllQueueList();
    void actionOnQueue(String userName);
}
