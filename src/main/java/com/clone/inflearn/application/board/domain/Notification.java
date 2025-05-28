package com.clone.inflearn.application.board.domain;

import com.clone.inflearn.util.jpa.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Notification extends BaseEntity {
    @Comment("알림 내용")
    private String message;

    @Comment("관련 게시글 ID (nullable)")
    private Long boardId;
}
