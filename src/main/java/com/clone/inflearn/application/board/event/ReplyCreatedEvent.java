package com.clone.inflearn.application.board.event;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ReplyCreatedEvent {
    public Long boardId;
}
