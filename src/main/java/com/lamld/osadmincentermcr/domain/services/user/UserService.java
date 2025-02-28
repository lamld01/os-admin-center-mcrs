package com.lamld.osadmincentermcr.domain.services.user;

import com.lamld.osadmincentermcr.app.response.user.UserResponse;
import com.lamld.osadmincentermcr.domain.entities.user.AccountEntity;
import com.lamld.osadmincentermcr.domain.entities.user.UserEntity;
import com.lamld.osadmincentermcr.domain.shareService.user.AccountShareService;
import com.lamld.osadmincentermcr.domain.shareService.user.UserShareService;
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
