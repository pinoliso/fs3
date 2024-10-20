package com.duoc.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duoc.models.Book;

@Repository
public class BookRepository extends JpaRepository<Book, Long> {
    
}
