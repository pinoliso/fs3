package com.duoc.fs3.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.duoc.fs3.models.Book;
import com.duoc.fs3.services.BookService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getBooks() {
        return bookService.getBooks();  
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id) {
        Optional<Book> book = bookService.getBook(id);
        if (book.isPresent()) {
            return ResponseEntity.ok(book.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        Optional<Book> bookOpt = bookService.getBook(id);
        if (bookOpt.isPresent()) {
            Book bookBD = bookOpt.get();
            bookBD.setTitle(book.getTitle());
            bookBD.setAuthor(book.getAuthor());
            bookBD.setPublisherYear(book.getPublisherYear());
            bookBD.setGenre(book.getGenre());
            bookService.addBook(bookBD);
            return ResponseEntity.ok(bookBD);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    
}
