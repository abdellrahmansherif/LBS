package com.example.lbs.Controllers;

import com.example.lbs.DTO.AddBookRequest;
import com.example.lbs.DTO.AddCategoryRequest;
import com.example.lbs.Service.BookCategoryService;
import com.example.lbs.Service.BookService;
import com.example.lbs.Service.LoanService;
import com.example.lbs.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    UserService userService;
    @Autowired BookCategoryService BookCategoryService;
    @Autowired
    LoanService loanService;
    @Autowired
    BookService bookService;

    @PostMapping("/AddCategory")
    public ResponseEntity<?> addCategory(@RequestBody AddCategoryRequest req)
    {
        try{
            return ResponseEntity.ok(BookCategoryService.AddCategory(req.categoryName()));
        } catch (IllegalStateException e) {
            return ResponseEntity.status(409).body(e.getMessage()); // conflict
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Unexpected error");
        }
    }

    @DeleteMapping("/RemoveCategory/{categoryName}")
    public ResponseEntity<?> RemovecategoryName(@PathVariable("categoryName") String title)
    {
        try {
            return ResponseEntity.ok(BookCategoryService.RemoveCategory(title));
        }
        catch (IllegalStateException e)
        {
            return ResponseEntity.status(409).body(e.getMessage());
        }
        catch (Exception e)
        {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping("/AddBook")
    public ResponseEntity<?> AddBook(@RequestBody AddBookRequest req)
    {
        try{
            return ResponseEntity.ok(bookService.AddBook(req));
        } catch (IllegalStateException e) {
            return ResponseEntity.status(409).body(e.getMessage()); // conflict
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Unexpected error");
        }
    }

    @DeleteMapping("/RemoveBook/{title}")
    public ResponseEntity<?> RemoveBook(@PathVariable("title") String title)
    {
        try {
            return ResponseEntity.ok(bookService.RemoveBook(title));
        }
        catch (IllegalStateException e)
        {
            return ResponseEntity.status(409).body(e.getMessage());
        }
        catch (Exception e)
        {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
    //hi

}
