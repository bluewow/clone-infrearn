package com.clone.inflearn.application.board.service;


import com.clone.inflearn.application.board.domain.Board;
import com.clone.inflearn.application.board.domain.Reply;
import com.clone.inflearn.application.board.repository.ReplyProjection;
import com.clone.inflearn.application.board.repository.ReplyQueryRepository;
import com.clone.inflearn.application.board.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class ReplyService {
    private final ReplyRepository replyRepository;
    private final ReplyQueryRepository replyQueryRepository;

    public void createReply(Board board, String content, Long userId) {
        Reply reply = new Reply(content, userId, board);
        replyRepository.save(reply);
    }

    public List<ReplyProjection> getReplyByBoardId(Long id) {
        return replyQueryRepository.getRepliesByBoardId(id);
    }
}
