package org.example.automarket24backend.email;

import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailService {

    private JavaMailSender javaMailSender;

    public void sendEmail(EmailDto emailDto) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(emailDto.from());
//        message.setTo(emailDto.to());
        message.setTo("siwapiw141@adrais.com");
        message.setSubject(emailDto.title());
        message.setText(emailDto.text());

        javaMailSender.send(message);
    }
}
