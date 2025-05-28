package com.clone.inflearn.application.board.facade;

import com.clone.inflearn.application.board.domain.Board;
import com.clone.inflearn.application.board.domain.Reply;
import com.clone.inflearn.application.board.dto.BoardRequest;
import com.clone.inflearn.application.board.dto.BoardResponse;
import com.clone.inflearn.application.board.repository.ReplyProjection;
import com.clone.inflearn.application.board.service.BoardService;
import com.clone.inflearn.application.board.service.ReplyService;
import com.clone.inflearn.application.user.service.UserService;
import com.clone.inflearn.util.wrapper.PageWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class BoardFacade {
    private final BoardService boardService;
    private final ReplyService replyService;
    private final UserService userService;

    public BoardResponse createBoard(BoardRequest request) {
        Board board = boardService.createBoard(request.title, request.content);

        return new BoardResponse(board.getId());
    }

    public void deleteBoard(Long boardId) {
        Board board = boardService.getBoardById(boardId);
        board.delete();
    }

    public void updateBoard(BoardRequest request) {
        Board targetBoard = boardService.getBoardById(request.boardId);
        targetBoard.update(request.title, request.content);
    }

    public BoardResponse getBoard(Long id) {
        Board board = boardService.getBoardById(id);
        List<ReplyProjection> list = replyService.getReplyByBoardId(id);

        return new BoardResponse(board.getId(), board.getTitle(), board.getContent(), list);
    }

    public PageWrapper<BoardResponse> getBoards(Pageable pageable) {
        Page<Board> boards = boardService.getBoards(pageable);

        return new PageWrapper<>(
                boards.getTotalElements(),
                boards.getTotalPages(),
                boards.getContent().stream()
                        .map(BoardResponse::new)
                        .toList());
    }
}
