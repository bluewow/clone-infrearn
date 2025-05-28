package com.clone.inflearn.application.board.repository;

import com.clone.inflearn.application.board.domain.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    List<Reply> findAllByBoardId(Long id);
}
