package org.example.automarket24backend.email;

import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@RabbitListener(queues = "email")
public class EmailReceiver {

    private EmailService emailService;

    @RabbitHandler
    public void listen(EmailDto emailDto) {
        emailService.sendEmail(emailDto);
    }
}
