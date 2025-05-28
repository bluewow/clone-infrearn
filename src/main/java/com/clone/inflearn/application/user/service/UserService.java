package com.clone.inflearn.application.user.service;

import com.clone.inflearn.application.user.domain.User;
import com.clone.inflearn.application.user.repository.UserRepository;
import com.clone.inflearn.util.exception.CustomException;
import com.clone.inflearn.util.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Transactional
@Service
public class UserService {
    private final UserRepository userRepository;

    public User login(String userId, String password) {
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND));

        if (!user.getPassword().equals(password)) {
            throw new CustomException(ErrorCode.INVALID_PARAM);
        }

        return user;
    }

    public List<String> getUserName(List<Long> userIds) {
        return userRepository.findUserNamesByUserIdIn(userIds);
    }
}
