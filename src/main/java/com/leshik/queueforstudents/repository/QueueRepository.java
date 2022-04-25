package com.leshik.queueforstudents.repository;

import com.leshik.queueforstudents.model.QueueEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QueueRepository extends JpaRepository<QueueEntity, Long> {
    List<QueueEntity> findAllByOrderByEntryTime();

    void deleteByUser_UserName(String name);
}
