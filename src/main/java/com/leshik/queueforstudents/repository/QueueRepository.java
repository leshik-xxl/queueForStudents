package com.leshik.queueforstudents.repository;

import com.leshik.queueforstudents.model.Queue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QueueRepository extends JpaRepository<Queue, Long> {
}
