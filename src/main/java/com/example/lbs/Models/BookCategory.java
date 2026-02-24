package com.example.lbs.Models;

import jakarta.persistence.*;

@Entity
@Table(name="book_category")

public class BookCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="category_id")
    private Long id;

    public BookCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    @Column(name = "category_name", nullable = false, unique = true, length = 120)
    private String categoryName;

    public BookCategory() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
