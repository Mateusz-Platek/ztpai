package org.example.automarket24backend.email;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "email")
public class EmailReceiver {

    @RabbitHandler
    public void listen(EmailDto emailDto) {
        System.out.println(emailDto);
    }
}
