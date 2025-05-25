package com.clone.inflearn.application.board.facade;

import com.clone.inflearn.application.board.domain.Board;
import com.clone.inflearn.application.board.dto.BoardRequest;
import com.clone.inflearn.application.board.dto.BoardResponse;
import com.clone.inflearn.application.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class BoardFacade {
    private final BoardService boardService;

    public BoardResponse createBoard(BoardRequest request) {
        Board board = boardService.createBoard(request.title, request.content);

        return new BoardResponse(board.getId());
    }
}
