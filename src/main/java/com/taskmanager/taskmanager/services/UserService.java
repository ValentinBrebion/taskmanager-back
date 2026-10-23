package com.taskmanager.taskmanager.services;
import com.taskmanager.taskmanager.repository.UserRepository;
import com.taskmanager.taskmanager.entity.User;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository userRepository;

    public User saveOrUpdate(User user) {
        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }
}
