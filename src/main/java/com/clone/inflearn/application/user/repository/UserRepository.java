package com.clone.inflearn.application.user.repository;

import com.clone.inflearn.application.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserId(String userId);

    List<String> findUserNamesByUserIdIn(List<Long> userIds);
}
