package com.lamld.osadmincentermcrs.domain.services.user;

import com.lamld.osadmincentermcrs.app.response.user.UserResponse;
import com.lamld.osadmincentermcrs.domain.entities.user.AccountEntity;
import com.lamld.osadmincentermcrs.domain.entities.user.UserEntity;
import com.lamld.osadmincentermcrs.domain.shareService.user.AccountShareService;
import com.lamld.osadmincentermcrs.domain.shareService.user.UserShareService;
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
