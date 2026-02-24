package com.example.lbs.Repos;

import com.example.lbs.Models.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepo extends JpaRepository<Loan,Long> {

}
