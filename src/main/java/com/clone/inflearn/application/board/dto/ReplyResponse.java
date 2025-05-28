package com.clone.inflearn.application.board.dto;

import com.clone.inflearn.application.board.domain.Reply;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ReplyResponse {
    public Long id;
    public String content;
    public String writer;

    public ReplyResponse(Reply reply) {
        this.id = reply.getId();
        this.content = reply.getContent();
//        this.writer = reply.getWriter().getName(); // 연관관계를 이용하여 호출이 가능한 구조였음
    }
}
