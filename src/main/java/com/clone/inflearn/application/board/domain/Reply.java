package com.clone.inflearn.application.board.domain;

import com.clone.inflearn.util.jpa.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reply extends BaseEntity {

    @Comment("답글 내용")
    private String content;

    @Comment("답글 작성자 아이디")
    private Long userId;

    @Comment("게시판 아이디")
    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;
}
