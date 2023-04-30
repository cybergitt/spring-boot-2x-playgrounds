package com.coffeegit.springboot.jpamysql.basic.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class UserDto {
    
    private UserDto() {}

    @Getter
    @Setter
    @Builder
    public static class UserRequest {

        @NotEmpty(message = "first name cannot be empty")
        private String firstName;

        @NotEmpty(message = "last name cannot be empty")
        private String lastName;

        @NotEmpty(message = "email cannot be empty")
        @Email
        private String email;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class UserResponse {

        private String firstName;

        private String lastName;

        private String email;
    }
}
