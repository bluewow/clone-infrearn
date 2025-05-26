package com.clone.inflearn.application.board.dto;

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
}
