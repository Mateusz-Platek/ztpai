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
    public ResponseEntity<List<User>> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(Integer userId) {
        return userService.getUser(userId);
    }

//    @PostMapping
//    public ResponseEntity<User> addUser(@RequestBody UserDto userDto) {
//        return userService.saveUser(userDto);
//    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<User> removeUser(@PathVariable Integer userId) {
        return userService.removeUser(userId);
    }
}
