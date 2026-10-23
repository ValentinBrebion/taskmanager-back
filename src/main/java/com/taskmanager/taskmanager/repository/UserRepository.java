package com.taskmanager.taskmanager.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import com.taskmanager.taskmanager.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
