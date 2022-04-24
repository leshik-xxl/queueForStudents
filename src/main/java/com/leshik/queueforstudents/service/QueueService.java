package com.leshik.queueforstudents.service;

import com.leshik.queueforstudents.api.response.Queue;

import java.util.List;

public interface QueueService {
    List<Queue> getAllQueueList();
    void takeTheQueue(String userName);
    void leaveTheQueue(String userName);
}
