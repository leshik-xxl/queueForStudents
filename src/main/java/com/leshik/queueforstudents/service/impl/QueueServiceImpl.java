package com.leshik.queueforstudents.service.impl;

import com.leshik.queueforstudents.api.model.Queue;
import com.leshik.queueforstudents.exeption.NotFoundUserException;
import com.leshik.queueforstudents.model.QueueEntity;
import com.leshik.queueforstudents.model.UserEntity;
import com.leshik.queueforstudents.repository.QueueRepository;
import com.leshik.queueforstudents.repository.UserRepository;
import com.leshik.queueforstudents.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QueueServiceImpl implements QueueService {

    private final QueueRepository queueRepository;
    private final UserRepository userRepository;

    @Autowired
    public QueueServiceImpl(QueueRepository queueRepository, UserRepository userRepository) {
        this.queueRepository = queueRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public List<Queue> getAllQueueList() {
        var wrapper = new Object() {
            long ordinal = 1;
        };
        return queueRepository.findAllByOrderByEntryTime().stream()
                .map(x -> new Queue(wrapper.ordinal++, x.getUser().getUserName()))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void actionOnQueue(String userName) {
        UserEntity user = userRepository.findByUserName(userName).orElseThrow(() -> new NotFoundUserException(userName));
        Optional<QueueEntity> queue = queueRepository.findByUser(user);
        if (queue.isPresent()) {
            queueRepository.deleteByUser_UserName(userName);
        } else {
            queueRepository.save(new QueueEntity(user));
        }
    }
}
