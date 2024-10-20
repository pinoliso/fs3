package com.duoc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoc.repositories.BookRepository;

@Service
public class BookService {
    
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getBooks() {
        return bookRepository.getBooks();
    }

    public Optional<Book> getBook(int id) {
        return bookRepository.getBook(id);
    }

    public Book addBook(Book book) {
        return bookRepository.addBook(book);
    }

    public void deleteBook(int id) {
        bookRepository.deleteBook(id);
    }
}
