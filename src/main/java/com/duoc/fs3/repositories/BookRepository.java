package com.duoc.fs3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duoc.fs3.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    
}
