package com.clone.inflearn.application.board.dto;

import com.clone.inflearn.application.board.domain.Board;
import com.clone.inflearn.application.board.domain.Reply;
import com.clone.inflearn.application.board.repository.ReplyProjection;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

import static java.util.stream.Collectors.toList;

@NoArgsConstructor
public class BoardResponse {
    public Long boardId;
    public String title;
    public String content;
    public List<ReplyProjection> replies;


    public BoardResponse(Long id) {
        this.boardId = id;
    }

    public BoardResponse(Board board) {
        this.boardId = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
    }

    public BoardResponse(Long boardId, String title, String content, List<ReplyProjection> list) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        this.replies = list;
    }
}
