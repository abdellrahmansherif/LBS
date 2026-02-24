package com.example.lbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com/example/lbs/Models")
@EnableJpaRepositories(basePackages = "com/example/lbs/Repos")
@ComponentScan({"com/example/lbs/Controllers", "com/example/lbs/Service", "com/example/lbs/Repos", "com/example/lbs/Models", "com.example.lbs"})
public class LbsApplication {

    public static void main(String[] args) {
        SpringApplication.run(LbsApplication.class, args);
    }

}
