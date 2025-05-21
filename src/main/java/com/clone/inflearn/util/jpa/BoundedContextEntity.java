package com.clone.inflearn.util.jpa;

import com.clone.inflearn.util.enums.Status;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.hibernate.annotations.Comment;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class BoundedContextEntity extends BaseEntity{
    @Comment("상태")
    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;
}
