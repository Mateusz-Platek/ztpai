package org.example.automarket24backend.security;

public record LoginRequest(
        String email,
        String password
) {
}
