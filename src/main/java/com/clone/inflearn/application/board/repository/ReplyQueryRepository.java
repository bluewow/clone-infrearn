package com.clone.inflearn.application.board.repository;

import com.clone.inflearn.application.board.domain.QReply;
import com.clone.inflearn.application.board.domain.Reply;
import com.clone.inflearn.application.user.domain.QUser;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.clone.inflearn.application.board.domain.QReply.reply;

@RequiredArgsConstructor
@Repository
public class ReplyQueryRepository {
    private final JPAQueryFactory queryFactory;

    public List<ReplyProjection> getRepliesByBoardId(Long boardId) {
        QReply reply = QReply.reply;
        QUser user = QUser.user;

        return queryFactory
                .select(Projections.fields(ReplyProjection.class,
                        reply.id,
                        reply.content,
                        user.userId.as("writer")
                ))
                .from(reply)
                .join(user).on(reply.userId.eq(user.id))
                .where(reply.board.id.eq(boardId))
                .orderBy(reply.createdAt.asc())
                .fetch();
    }
}
