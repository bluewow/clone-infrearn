package com.clone.inflearn.application.board.event;

import com.clone.inflearn.application.board.repository.NotificationRepository;
import com.clone.inflearn.application.board.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Comment;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardEventNotificationHandler {
    private final NotificationService notificationService;

    @EventListener
    public void handleReplyCreated(ReplyCreatedEvent event) {
        notificationService.createNotification(event.boardId);
    }
}
