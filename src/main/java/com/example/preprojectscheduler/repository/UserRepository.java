package com.example.preprojectscheduler.repository;

import com.example.preprojectscheduler.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.notification = true")
    List<User> findByNotificationTrue();
}
