package com.clone.inflearn.application.board.api;

import com.clone.inflearn.application.board.domain.Board;
import com.clone.inflearn.application.board.dto.BoardRequest;
import com.clone.inflearn.application.board.dto.BoardResponse;
import com.clone.inflearn.application.board.facade.BoardFacade;
import com.clone.inflearn.util.dto.ApiResponse;
import com.clone.inflearn.util.exception.CustomException;
import com.clone.inflearn.util.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BoardApi {
    private final BoardFacade boardFacade;

    @PostMapping("/board")
    public ApiResponse<BoardResponse> createBoard(@RequestBody BoardRequest request) {
        // 유효성 검사
        if (request.title == null || request.content == null) {
            throw new CustomException(ErrorCode.INVALID_PARAM);
        }
        // 게시판 생성 로직
        return ApiResponse.success(boardFacade.createBoard(request));
    }

    @DeleteMapping("/board")
    public ApiResponse<Void> deleteBoard(Long boardId) {
        // 유효성 검사
        if (boardId == null) {
            throw new CustomException(ErrorCode.INVALID_PARAM);
        }

        // 게시판 삭제 로직
        boardFacade.deleteBoard(boardId);
        return ApiResponse.success();
    }

    @PutMapping("/board")
    public ApiResponse<Void> updateBoard(@RequestBody BoardRequest request) {
        boardFacade.updateBoard(request);
        return ApiResponse.success();
    }

}
