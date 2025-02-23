package com.lamld.mossellermcrs.app.dto.auth;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import vn.mos.core.base.type.UserRole;

@Getter
@Setter
public class RegisterRequest {
    private String username;
    private UserRole userRole;
    private String password;
    private String displayName;
    private String phoneNumber;
    private String email;
}
