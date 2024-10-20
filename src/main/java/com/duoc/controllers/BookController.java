package com.duoc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.duoc.models.Book;
import com.duoc.services.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getBooks() {
        return bookService.getBooks();  
    }

    @PostMapping
    public String addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping("/id")
    public ResponseEntity<Book> getBook(@RequestParam Long id) {
        return bookService.getBook(id);
    }
    
    @DeleteMapping("/id")
    public void deleteBook(@RequestParam Long id) {
        bookService.deleteBook(id);
    }
    
}
