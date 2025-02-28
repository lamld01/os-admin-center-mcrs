package com.lamld.mossellermcrs.app.controllers.auth;

import com.lamld.mossellermcrs.app.dto.auth.AuthRequest;
import com.lamld.mossellermcrs.app.dto.auth.RegisterRequest;
import com.lamld.mossellermcrs.app.response.auth.AuthResponse;
import com.lamld.mossellermcrs.domain.services.user.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.mos.core.base.BaseResponse;

@RestController
@RequestMapping("/v1/admin-center/public/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AccountService authService;

    @PostMapping("/register")
    public BaseResponse<AuthResponse> register(@RequestBody RegisterRequest request) {
        return BaseResponse.success(authService.register(request));
    }

    @PostMapping("/login")
    public BaseResponse<AuthResponse> login(@RequestBody AuthRequest request) {
        return BaseResponse.success(authService.authenticate(request));
    }
}
