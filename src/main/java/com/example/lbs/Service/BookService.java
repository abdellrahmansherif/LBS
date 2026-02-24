package com.example.lbs.Service;

import com.example.lbs.DTO.AddBookRequest;
import com.example.lbs.Models.Book;
import com.example.lbs.Models.BookCategory;
import com.example.lbs.Repos.BookCategoryRepo;
import com.example.lbs.Repos.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookRepo bookRepo;

    @Autowired
    BookCategoryRepo bookCategoryRepo;

    public Book FindBook(String BookTitle)
    {
        String title = BookTitle == null ? null : BookTitle.trim();
        if(title==null||title.isBlank())throw new IllegalStateException("title is required");

        Book book=bookRepo.findByTitle(BookTitle);
        if(book==null)throw new IllegalStateException("Book not found");
        return book;
    }

    public Book AddBook(AddBookRequest book)
    {
        Book findbook= bookRepo.findByTitle(book.title());
        if(findbook!=null)throw new IllegalStateException("Book is already found");

        BookCategory Category=bookCategoryRepo.findByCategoryName(book.category());
        if(Category==null)
        {
            throw new IllegalStateException("Category not found");
        }
        Book saved=new Book(book.title(),book.author(),Category);
        bookRepo.save(saved);
        return saved;
    }

    public Book RemoveBook(String title)
    {
        Book book=FindBook(title);
        bookRepo.delete(book);
        return book;
    }

}
