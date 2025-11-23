package com.example.noticeboard.Service;

import com.example.noticeboard.dto.CreateUserRequest;
import com.example.noticeboard.model.User;
import com.example.noticeboard.model.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor

public class UserService {

    private final UserRepository userRepository;

    public User createUser(String username, String password) {
        User user = User.builder()
                .username(username)
                .password(password)
                .build();
        return userRepository.save(user);
    }

    public User getUserByid(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User UpdateUser(Long id, String username, String password) {
      User user =  userRepository.findById(id).orElse(null);
        user.Update(username,password);
        return userRepository.save(user);
    }

    public boolean deleteUser(Long id) {
        if(userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}