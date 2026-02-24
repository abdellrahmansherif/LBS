package com.example.lbs.Service;

import com.example.lbs.Models.Book;
import com.example.lbs.Models.Loan;
import com.example.lbs.Models.User;
import com.example.lbs.Repos.LoanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LoanService {

    @Autowired
    LoanRepo loanRepo;
    @Autowired
    BookService bookService;

    @Autowired
    UserService userService;

    public Loan AddLoan(String UserName,String BookTitle)
    {
        User user=userService.FindUser(UserName);
        Book book=bookService.FindBook(BookTitle);

        LocalDateTime loanDate = LocalDateTime.now();
        Loan loan =new Loan(user,book, loanDate,loanDate.plusDays(14));
        loanRepo.save(loan);
        return loan;
    }
}
