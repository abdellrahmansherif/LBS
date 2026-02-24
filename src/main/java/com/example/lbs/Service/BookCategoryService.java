package com.example.lbs.Service;

import com.example.lbs.Models.BookCategory;
import com.example.lbs.Repos.BookCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookCategoryService {
    @Autowired
    BookCategoryRepo bookCategoryRepo;

    public BookCategory FindCAtegory(String categoryName)
    {
        String name = categoryName == null ? null : categoryName.trim();
        if(name==null||name.isBlank())throw new IllegalStateException("Category name is required");

        BookCategory category=bookCategoryRepo.findByCategoryName(name);

        if(category!=null)
        {
            return category;
        }
        throw new IllegalStateException("Category not found");
    }

    public BookCategory AddCategory(String categoryName)
    {
        String name = categoryName == null ? null : categoryName.trim();
        if(name==null||name.isBlank())throw new IllegalStateException("Category name is required");

        BookCategory category=bookCategoryRepo.findByCategoryName(name);
        if(category!=null)throw new IllegalStateException("category alreay exist");

        BookCategory saved=bookCategoryRepo.save(new BookCategory(categoryName));
        return saved;
    }

    public BookCategory RemoveCategory(String categoryName)
    {
        BookCategory Category =bookCategoryRepo.findByCategoryName(categoryName);
        bookCategoryRepo.delete(Category);
        return Category;
    }
}
