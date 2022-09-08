package com.coffeegit.springboot.jpamysql.model.dto.request;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.coffeegit.springboot.jpamysql.model.enums.RoleEnum;

import lombok.Getter;
import lombok.Setter;

public class AccountRequest {

    private AccountRequest() {}
    
    @Getter
    @Setter
    public static class SignUp {

        @NotEmpty(message = "Please provide First Name")
        private String firstName;

        private String lastName;

        @NotEmpty(message = "Please provide Email")
        @Size(max = 345)
        // @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$", message = "It doesn't fit the email format.")
        @Email(message = "Please provide a Valid Email")
        private String email;

//        @NotEmpty(message = "Please provide Password")
//        @Size(min = 6, message = "Please provide Password with minimum 6 characters")
//        // @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{6,16}$", message = "{registration_password_size}")
//        private String password;

        @Enumerated(EnumType.STRING)
        private RoleEnum role;
    }

    @Getter
    @Setter
    public static class SignIn {

        @NotEmpty(message = "Email must not be empty")
        // @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$", message = "It doesn't fit the email format.")
        @Email(message = "Please provide a Valid Email")
        @Size(min = 6, max = 345, message = "Please provide Email with minimum 6 characters")
        private String email;

        @NotEmpty(message = "Password must not be empty")
        private String password;
    }

    @Getter
    @Setter
    public static class Reissue {

        @NotEmpty(message = "Please provide Token")
        private String accessToken;

        // @NotEmpty(message = "{jwt_refresh_token_not_empty}")
        // private String refreshToken;
    }

    @Getter
    @Setter
    public static class ChangePassword {

        @NotEmpty(message = "Please provide Current Password")
        private String oldPassword;
        
        @NotEmpty(message = "Please provide New Password")
        private String newPassword;
    }

    @Getter
    @Setter
    public static class Logout {

        @NotEmpty(message = "Please provide Token")
        private String accessToken;
    }
}
