package com.clone.inflearn.application.board.service;

import com.clone.inflearn.application.board.domain.Board;
import com.clone.inflearn.application.board.repository.BoardRepository;
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
}
