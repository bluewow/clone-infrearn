package com.clone.inflearn.application.board.service;

import com.clone.inflearn.application.board.domain.Board;
import com.clone.inflearn.application.board.repository.BoardRepository;
import com.clone.inflearn.util.exception.CustomException;
import com.clone.inflearn.util.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public Board createBoard(String title, String content) {
        Board board = new Board(title, content);

        return boardRepository.save(board);
    }

    public Board getBoardId(Long boardId) {
        return boardRepository.findById(boardId)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND));
    }
}
