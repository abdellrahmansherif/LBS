package com.example.lbs.Controllers;

import com.example.lbs.DTO.AddLoanRequest;
import com.example.lbs.DTO.LoginRequest;
import com.example.lbs.Models.User;
import com.example.lbs.Service.BookCategoryService;
import com.example.lbs.Service.BookService;
import com.example.lbs.Service.LoanService;
import com.example.lbs.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class Controller {
    @Autowired UserService userService;
    @Autowired BookCategoryService BookCategoryService;
    @Autowired LoanService loanService;
    @Autowired BookService bookService;

    @PostMapping("/SignUp")
    public ResponseEntity<?> signUp(@RequestBody User user) {
        try {
            return ResponseEntity.ok(userService.SignUp(user));
        } catch (IllegalStateException e) {
            return ResponseEntity.status(409).body(e.getMessage()); // conflict
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Unexpected error");
        }
    }
    @PostMapping("/Login")
    public String  login(@RequestBody LoginRequest req)
    {
        return userService.SignIn(req.userName(),req.password());
    }

    @GetMapping("/Category/{CategoryName}")
    public ResponseEntity<?> FindCAtegory(@PathVariable("CategoryName") String Name)
    {
        return ResponseEntity.ok(BookCategoryService.FindCAtegory(Name));
    }


    @GetMapping("/Book/{title}")
    public ResponseEntity<?> FindBook(@PathVariable("title") String Name)
    {
        try {
            return ResponseEntity.ok(bookService.FindBook(Name));
        }
        catch (IllegalStateException e)
        {
            return ResponseEntity.status(409).body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.status(500).body("Unexpected error");
        }
    }


    @PostMapping("/AddLoan")
    public ResponseEntity<?> AddLoan(@RequestBody AddLoanRequest req)
    {
        try {
            return ResponseEntity.ok(loanService.AddLoan(req.UserName(), req.BookTitle()));
        }
        catch (IllegalStateException e)
        {
            return ResponseEntity.status(409).body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.status(500).body("Unexpected error");
        }
    }

}
