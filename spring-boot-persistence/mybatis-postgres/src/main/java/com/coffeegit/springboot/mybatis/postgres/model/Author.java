package com.coffeegit.springboot.mybatis.postgres.model;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    
    private Long id;

    @NotBlank
    private String firstName;

    private String lastName;
}
