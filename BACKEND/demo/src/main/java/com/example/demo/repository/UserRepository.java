package com.example.demo.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
import com.example.demo.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
    Optional<User> findByUsername(String username);
}