package com.example.noticeboard.Service;

import com.example.noticeboard.model.User;
import com.example.noticeboard.model.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UserService {
    private final UserRepository userRepository;

   public User createUser(String username, String password) {
       User user =  User.builder()
               .username(username)
               .password(password)
               .build();
       return user;
   }


    public User getUserId(long id) {
   return userRepository.getById(id);
   }

    public User updateUser(long id, String username, String password) {
       User user = userRepository.findById(id).orElse(null);
       user.update(username,password);
       return userRepository.save(user);
    }

    public boolean deleteuser(long id) {
        if(userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;

    }
}
