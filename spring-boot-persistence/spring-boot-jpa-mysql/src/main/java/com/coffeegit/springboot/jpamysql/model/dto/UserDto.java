package com.coffeegit.springboot.jpamysql.model.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.coffeegit.springboot.jpamysql.model.enums.RoleEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(
	ignoreUnknown = true
)
public class UserDto {

	@NotEmpty(message = "First name can not be empty")
    private String firstName;

    @NotEmpty(message = "Last name can not be empty")
    private String lastName;

    @NotEmpty(message = "Email can not be empty")
    @Email(message = "Please provide a valid email")
    private String email;

    @Enumerated(EnumType.STRING)
    private RoleEnum role;
    
    @JsonIgnore
    private boolean enabled;

}
