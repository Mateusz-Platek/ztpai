package org.example.automarket24backend.security;

import lombok.AllArgsConstructor;
import org.example.automarket24backend.user.User;
import org.example.automarket24backend.user.UserDto;
import org.example.automarket24backend.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationService {

    private AuthenticationManager authenticationManager;
    private UserService userService;
    private JwtService jwtService;

    public ResponseEntity<AuthenticationResponse> register(UserDto userDto) {
        User user = userService.saveUser(userDto);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        String jwt = jwtService.generateJwt(user);

        return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
    }

    public ResponseEntity<AuthenticationResponse> login(LoginRequest loginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password()));
        User user = userService.getUser(loginRequest.email());
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        String jwt = jwtService.generateJwt(user);

        return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
    }
}
