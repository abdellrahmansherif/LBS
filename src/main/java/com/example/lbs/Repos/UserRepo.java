package com.example.lbs.Repos;

import com.example.lbs.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByEmail(String email);
    User findByUserName(String username);

}
