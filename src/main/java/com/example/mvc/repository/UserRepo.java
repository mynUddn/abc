package com.example.mvc.repository;

import com.example.mvc.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserModel, Integer> {
}
