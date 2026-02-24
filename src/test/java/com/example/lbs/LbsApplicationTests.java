package com.example.lbs;

import com.example.lbs.Models.User;
import com.example.lbs.Repos.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LbsApplicationTests {

    @Autowired
    private UserRepo userRepo;

    @Test
    public void AddUser() {
        User user=new User("ahmed","@gmail","pas123","012");
        userRepo.save(user);
    }

}
