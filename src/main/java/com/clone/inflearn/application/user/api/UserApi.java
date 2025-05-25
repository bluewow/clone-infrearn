package com.clone.inflearn.application.user.api;

import com.clone.inflearn.application.user.dto.LoginRequest;
import com.clone.inflearn.application.user.dto.LoginResponse;
import com.clone.inflearn.application.user.facade.UserFacade;
import com.clone.inflearn.util.dto.ApiResponse;
import com.clone.inflearn.util.exception.CustomException;
import com.clone.inflearn.util.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserApi {
    private final UserFacade userFacade;

    @PostMapping("/login")
    public ApiResponse<LoginResponse> login(@RequestBody LoginRequest request) {
        // 유효성 검사
        if (request.userId == null || request.password == null) {
            throw new CustomException(ErrorCode.INVALID_ACCESS);
        }

        return ApiResponse.success(userFacade.login(request));
    }
}
