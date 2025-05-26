package com.clone.inflearn.application.board.dto;

import com.clone.inflearn.application.board.domain.Board;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class BoardResponse {
    public Long boardId;
    public String title;
    public String content;

    public BoardResponse(Long id) {
        this.boardId = id;
    }

    public BoardResponse(Board board) {
        this.boardId = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
    }
}
