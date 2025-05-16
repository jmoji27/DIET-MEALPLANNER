//package com.example.demo.Security;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//
//@Configuration
//@EnableWebSecurity
//@CrossOrigin("http://localhost:5173")
//public class SecurityConfig{
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity) throws Exception{
//        return httpSecurity.formLogin(httpForm ->{
//            httpForm.loginPage(LoginPage:"/login").permitAll();
//        })
//    }
//}