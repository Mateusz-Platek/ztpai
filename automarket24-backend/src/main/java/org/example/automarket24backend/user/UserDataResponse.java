package org.example.automarket24backend.user;

public record UserDataResponse(
        Integer id,
        String email,
        String phoneNumber,
        String location
) {
}
