package com.coffeegit.springboot.mybatis.postgres.service;

import java.util.List;

import com.coffeegit.springboot.mybatis.postgres.model.Book;

public interface BookService {
    
    Book create(Book book);

    List<Book> getAll();

    Book getOne(long id);

    void deleteById(long id);

    Book getByTitle(String title);
}
