package com.example.noticeboard.controllor;

import com.example.noticeboard.Service.UserService;
import com.example.noticeboard.dto.CreateUserRequest;
import com.example.noticeboard.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public User createUser(@RequestBody CreateUserRequest dto) {
        return userService.createUser(dto.getUsername(), dto.getPassword());
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUserByid(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody CreateUserRequest dto) {
        return userService.UpdateUser(id,dto.getUsername(),dto.getPassword());
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        boolean result = userService.deleteUser(id);
        return result ? "유저 삭제 성공" : "유저 삭제 실패";
    }
}
