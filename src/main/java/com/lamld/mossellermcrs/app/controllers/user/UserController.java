package com.lamld.mossellermcrs.app.controllers.user;

import com.lamld.mossellermcrs.app.dto.store.CreateStoreRequest;
import com.lamld.mossellermcrs.app.dto.store.UpdateStoreRequest;
import com.lamld.mossellermcrs.app.response.store.StoreResponse;
import com.lamld.mossellermcrs.app.response.user.UserResponse;
import com.lamld.mossellermcrs.domain.services.store.StoreService;
import com.lamld.mossellermcrs.domain.services.user.UserService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import vn.mos.core.base.BaseResponse;
import vn.mos.core.base.type.PageResponse;

@RestController
@RequestMapping("/v1/seller-center/user")
@RequiredArgsConstructor
@PreAuthorize("hasRole('SELLER')")
public class UserController {

    private final UserService userService;

    @GetMapping("/info")
    public UserResponse getUserInfo() {
        return userService.getUserInfo();
    }

}
