package com.clone.inflearn.application.board.event;

import com.clone.inflearn.application.board.service.NotificationService;
import com.clone.inflearn.util.LogUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

//@Transactional
@RequiredArgsConstructor
@Service
public class BoardEventNotificationHandler {
    private final NotificationService notificationService;

    @EventListener
    public void handleReplyCreated(ReplyCreatedEvent event) {
        LogUtils.logTxInfo("댓글 이벤트 처리 시작");
        notificationService.createNotification(event.boardId);
    }
}
