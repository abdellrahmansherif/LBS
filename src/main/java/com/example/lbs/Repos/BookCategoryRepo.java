package com.example.lbs.Repos;

import com.example.lbs.Models.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCategoryRepo extends JpaRepository<BookCategory,Long> {
    BookCategory findByCategoryName(String categoryName);
}
