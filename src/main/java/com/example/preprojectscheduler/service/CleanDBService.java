package com.example.preprojectscheduler.service;

import com.example.preprojectscheduler.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CleanDBService {
    private static final Logger logger = LoggerFactory.getLogger(CleanDBService.class);
    private final TestRepository testRepository;

    @Scheduled(cron = "0 */5 * * * *", zone = "Europe/Vilnius")
    public void cleanDB() {
        testRepository.deleteAll();
        logger.info("Clean DB completed");
    }
}
