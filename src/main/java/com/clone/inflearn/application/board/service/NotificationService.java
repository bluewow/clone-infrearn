package com.clone.inflearn.application.board.service;

import com.clone.inflearn.application.board.domain.Notification;
import com.clone.inflearn.application.board.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public void createNotification(Long boardId) {
        Notification notification = new Notification("메시지 첨부", boardId);
        notificationRepository.save(notification);

    }
}
