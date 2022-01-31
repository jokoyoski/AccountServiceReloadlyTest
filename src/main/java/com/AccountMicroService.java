package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



    @SpringBootApplication()
    @EnableAsync
    public class AccountMicroService {
        @Bean
        BCryptPasswordEncoder bCryptPasswordEncoder(){
            return new BCryptPasswordEncoder();
        }
        public static void main(String[] args) {
            SpringApplication.run(AccountMicroService.class, args);

        }
    }


