package com.leshik.queueforstudents.repository;

import com.leshik.queueforstudents.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);

    void deleteByLogin(String login);
}
