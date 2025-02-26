package com.lamld.mossellermcrs.app.controllers.auth;

import com.lamld.mossellermcrs.app.dto.auth.AuthRequest;
import com.lamld.mossellermcrs.app.dto.auth.RegisterRequest;
import com.lamld.mossellermcrs.app.response.auth.AuthResponse;
import com.lamld.mossellermcrs.domain.services.user.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/seller-center/public/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AccountService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
