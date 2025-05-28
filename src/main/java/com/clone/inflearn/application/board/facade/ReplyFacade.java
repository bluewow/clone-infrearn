package com.clone.inflearn.application.board.facade;

import com.clone.inflearn.application.board.domain.Board;
import com.clone.inflearn.application.board.dto.ReplyRequest;
import com.clone.inflearn.application.board.event.ReplyCreatedEvent;
import com.clone.inflearn.application.board.service.BoardService;
import com.clone.inflearn.application.board.service.NotificationService;
import com.clone.inflearn.application.board.service.ReplyService;
import com.clone.inflearn.util.auth.CustomPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class ReplyFacade {
    private final BoardService boardService;
    private final ReplyService replyService;
    private final ApplicationEventPublisher eventPublisher;

    public void createReply(ReplyRequest request) {
        Long userId = CustomPrincipal.getId();
        Board board = boardService.getBoardById(request.boardId);

        replyService.createReply(board, request.content, userId);
        eventPublisher.publishEvent(new ReplyCreatedEvent(request.boardId));

    }
}
