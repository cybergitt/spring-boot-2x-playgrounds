package com.coffeegit.springboot.mybatis.postgres.controller;

import java.text.MessageFormat;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffeegit.springboot.mybatis.postgres.common.exception.BadRequestException;
import com.coffeegit.springboot.mybatis.postgres.dto.response.SuccessResponse;
import com.coffeegit.springboot.mybatis.postgres.model.Book;
import com.coffeegit.springboot.mybatis.postgres.service.BookService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/book")
public class BookController {
    
    private final BookService bookService;

     @PostMapping()
     public ResponseEntity<SuccessResponse> create(@RequestBody @Valid Book book) {
         if (!ObjectUtils.isEmpty(book.getId())) {
             throw new BadRequestException("A new data cannot already have an ID");
         }

         return new ResponseEntity<>(
                 new SuccessResponse(bookService.create(book), "Successful submit"),
                 HttpStatus.CREATED);
     }

    @GetMapping
    public ResponseEntity<SuccessResponse> getAll() {
        List<Book> books = bookService.getAll();

        return new ResponseEntity<>(new SuccessResponse(books, MessageFormat.format("{0} Results found", books.size())), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuccessResponse> getOne(@PathVariable("id") Long id) {
        Book book = bookService.getOne(id);
        return new ResponseEntity<>(
                new SuccessResponse(book, "Result found"), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse> delete(@PathVariable("id") Long id) {
        bookService.deleteById(id);
        return new ResponseEntity<>(
                new SuccessResponse(null, "Deletion completed successfully"), HttpStatus.OK);
    }
}
