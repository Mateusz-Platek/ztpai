package org.example.automarket24backend.user;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponse>> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Integer userId) {
        return userService.getUser(userId);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<UserResponse> removeUser(@PathVariable Integer userId) {
        return userService.removeUser(userId);
    }
}
