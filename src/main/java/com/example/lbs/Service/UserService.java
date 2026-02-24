package com.example.lbs.Service;

import com.example.lbs.Configration.JWTservice;
import com.example.lbs.Models.User;
import com.example.lbs.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JWTservice jwTservice;

    @Autowired
    private AuthenticationManager authenticationManager;

    public User FindUser(String UserName)
    {
        User user=userRepo.findByUserName(UserName);
        if(user==null){
            throw new IllegalStateException("user not found");
        }
        return user;
    }
    public User SignUp(User user)
    {
        if(userRepo.findByEmail(user.getEmail())!=null) {
            throw new IllegalStateException("Email already exists");
        }
        if(userRepo.findByUserName(user.getUserName())!=null){
            throw new IllegalStateException("Username already exists");
        }
        return userRepo.save(user);
    }

    public String SignIn(String username, String password) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );
            return jwTservice.generateToken(username);
        } catch (Exception e) {
            Throwable root = e;
            while (root.getCause() != null) root = root.getCause();
            return "AUTH FAILED: " + e.getClass().getSimpleName()
                    + " | msg=" + e.getMessage()
                    + " | root=" + root.getClass().getSimpleName()
                    + " | rootMsg=" + root.getMessage();
        }
    }
}
