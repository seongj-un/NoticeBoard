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
    public User getUserById(@PathVariable long id) {
        return userService.getUserId(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable long id ,@RequestBody CreateUserRequest dto) {
    return userService.updateUser(id, dto.getUsername(), dto.getPassword());
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable long id) {
        boolean delete =userService.deleteuser(id);
        return delete ? "삭제 성공" : "삭제 실패: 해당 ID 없음";
    }


}
