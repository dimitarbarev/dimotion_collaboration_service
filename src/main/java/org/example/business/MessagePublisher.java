package org.example.business;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessagePublisher {

    private final RabbitTemplate rabbitTemplate;

    public MessagePublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishBoardDeleted(Long boardId) {
        System.out.println("Sending board delete event for ID: " + boardId);
        String message = String.valueOf(boardId);
        rabbitTemplate.convertAndSend("board.delete", message);
    }

    public void publishUserDeleted(Long userId) {
        System.out.println("Sending user delete event for ID: " + userId);
        String message = String.valueOf(userId);
        rabbitTemplate.convertAndSend("user.delete", message);
    }
}
