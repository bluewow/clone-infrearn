package com.clone.inflearn.application.user.domain;

import com.clone.inflearn.util.jpa.BoundedContextEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Getter
@NoArgsConstructor
@Entity
public class User extends BoundedContextEntity {

    @Comment("아이디")
    private String userId;

    @Comment("비밀번호")
    private String password;
}
