package com.example.lbs.Repos;

import com.example.lbs.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Long> {
    Book findByTitle(String title);


}
