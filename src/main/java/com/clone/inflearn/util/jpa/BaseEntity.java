package com.clone.inflearn.util.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Comment("최초 생성 시간")
    @CreatedDate
    private LocalDateTime createdAt;

    @Comment("마지막 수정 시간")
    @LastModifiedDate
    private LocalDateTime updatedAt;
}
