package com.example.preprojectscheduler.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import com.example.preprojectscheduler.entity.User;
import com.example.preprojectscheduler.repository.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class NotificationService {
    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);

    private final UserRepository userRepository;

    @Transactional
    @Scheduled(cron = "0 */5 * * * *")
    public void notification() {
        logger.info("Запуск проверки пользователей для уведомлений");

        List<User> users = userRepository.findByNotificationTrue();
        if(users.isEmpty()){
            logger.info("Нет пользователей для уведомления");
        }else {
            users.forEach(
                    user -> {
                        logger.info("Пользователь ID: {}, Email: {}", user.getId(), user.getEmail());
                        user.setNotification(false);
                        userRepository.save(user);
                    }
                    );
        }
    }

}
