package com.example.preprojectscheduler.service;

import com.example.preprojectscheduler.repository.TestRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CleanDBService {

    Logger logger = Logger.getLogger(CleanDBService.class.getName());
    TestRepository testRepository;
    public CleanDBService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Scheduled(cron = "0 */5 * * * *")
    public void cleanDB() {
        testRepository.deleteAll();
        logger.info("Clean DB completed");
    }

}
