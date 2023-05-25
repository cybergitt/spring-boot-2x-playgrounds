package com.coffeegit.springboot.mybatis.postgres.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String title;

    private int page;

    private String isbn;

    private String description;

    private double price;
}
