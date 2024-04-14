package org.example.automarket24backend.user;

public record UserDto(
        String email,
        String password,
        String phoneNumber,
        String location
) {
}
