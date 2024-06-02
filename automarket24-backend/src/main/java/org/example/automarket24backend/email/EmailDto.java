package org.example.automarket24backend.email;

public record EmailDto(
        String from,
        String to,
        String title,
        String text
) {
}
