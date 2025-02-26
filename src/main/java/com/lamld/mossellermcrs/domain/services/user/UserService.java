package com.lamld.mossellermcrs.domain.services.user;

import com.lamld.mossellermcrs.app.dto.auth.AuthRequest;
import com.lamld.mossellermcrs.app.dto.auth.RegisterRequest;
import com.lamld.mossellermcrs.app.response.auth.AuthResponse;
import com.lamld.mossellermcrs.app.response.user.UserResponse;
import com.lamld.mossellermcrs.domain.entities.user.AccountEntity;
import com.lamld.mossellermcrs.domain.entities.user.UserEntity;
import com.lamld.mossellermcrs.domain.shareService.user.AccountShareService;
import com.lamld.mossellermcrs.domain.shareService.user.UserShareService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService extends UserShareService {

    private final AccountShareService accountShareService;

    public UserResponse getUserInfo() {
        Long userId = getRequestUserId();
        UserEntity user = getExistUserById(userId);
        AccountEntity account = accountShareService.getExistUserAccountById(user.getAccountId());
        return new UserResponse(user, account);
    }
}
