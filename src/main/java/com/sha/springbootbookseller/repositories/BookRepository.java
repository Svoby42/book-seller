package com.sha.springbootbookseller.repositories;

import com.sha.springbootbookseller.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {



}
