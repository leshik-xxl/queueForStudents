package com.leshik.queueforstudents.repository;

import com.leshik.queueforstudents.model.QueueEntity;
import com.leshik.queueforstudents.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QueueRepository extends JpaRepository<QueueEntity, Long> {
    List<QueueEntity> findAllByOrderByEntryTime();
    void deleteByUser_Login(String name);
    Optional<QueueEntity> findByUser_Login(String name);
}
