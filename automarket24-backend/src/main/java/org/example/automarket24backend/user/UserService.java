package org.example.automarket24backend.user;

import lombok.AllArgsConstructor;
import org.example.automarket24backend.statusType.StatusType;
import org.example.automarket24backend.statusType.StatusTypeRepository;
import org.example.automarket24backend.userType.UserType;
import org.example.automarket24backend.userType.UserTypeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private StatusTypeRepository statusTypeRepository;
    private UserTypeRepository userTypeRepository;

    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<User> getUser(Integer userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return new ResponseEntity<>(new User(), HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    public ResponseEntity<User> save(UserDto userDto) {
        User user = userRepository.findUserByEmailContaining(userDto.email());
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.CONFLICT);
        }

        user = userRepository.findUserByPhoneNumberContaining(userDto.phoneNumber());
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.CONFLICT);
        }

        user = new User();
        user.setEmail(userDto.email());
        user.setPassword(userDto.password());
        user.setPhoneNumber(userDto.phoneNumber());
        user.setLocation(userDto.location());

        StatusType statusType = statusTypeRepository.getStatusTypeByName("Active");
        user.setStatusType(statusType);
        UserType userType = userTypeRepository.findUserTypeByName("Private");
        user.setUserType(userType);

        User saved = userRepository.save(user);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
}
