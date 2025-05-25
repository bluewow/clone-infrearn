package com.clone.inflearn.application.user.facade;

import com.clone.inflearn.application.user.domain.User;
import com.clone.inflearn.application.user.dto.LoginRequest;
import com.clone.inflearn.application.user.dto.LoginResponse;
import com.clone.inflearn.application.user.service.UserService;
import com.clone.inflearn.filter.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class UserFacade {
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    public LoginResponse login(LoginRequest request) {
        User login = userService.login(request.userId, request.password);

        String token = jwtTokenProvider.createAccessToken(login.getId());
        return new LoginResponse(token);
    }
}
