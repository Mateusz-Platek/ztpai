package org.example.automarket24backend.user;

import lombok.AllArgsConstructor;
import org.example.automarket24backend.statusType.StatusType;
import org.example.automarket24backend.statusType.StatusTypeRepository;
import org.example.automarket24backend.userType.UserType;
import org.example.automarket24backend.userType.UserTypeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private UserRepository userRepository;
    private StatusTypeRepository statusTypeRepository;
    private UserTypeRepository userTypeRepository;
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<User> getUser(Integer userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    public User getUser(String email) {
        return userRepository.findUserByEmail(email);
    }

    public User saveUser(UserDto userDto) {
        User user = userRepository.findUserByEmail(userDto.email());
        if (user != null) {
            return null;
        }

        user = userRepository.findUserByPhoneNumber(userDto.phoneNumber());
        if (user != null) {
            return null;
        }

        user = new User();
        user.setEmail(userDto.email());
        user.setPassword(passwordEncoder.encode(userDto.password()));
        user.setPhoneNumber(userDto.phoneNumber());
        user.setLocation(userDto.location());

        StatusType statusType = statusTypeRepository.getStatusTypeByName("Active");
        user.setStatusType(statusType);
        UserType userType = userTypeRepository.findUserTypeByName("Private");
        user.setUserType(userType);

        return userRepository.save(user);
    }

    public ResponseEntity<User> removeUser(Integer userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        userRepository.deleteById(userId);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findUserByEmail(email);
    }
}
