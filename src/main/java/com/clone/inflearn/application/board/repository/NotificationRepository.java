package com.clone.inflearn.application.board.repository;

import com.clone.inflearn.application.board.domain.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
