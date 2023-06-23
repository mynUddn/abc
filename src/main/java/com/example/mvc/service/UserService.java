package com.example.mvc.service;

import com.example.mvc.model.UserModel;
import com.example.mvc.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void saveUser(UserModel user){
        userRepo.save(user);
    }

    public List<UserModel> getUser(){
        List<UserModel> usersList = userRepo.findAll();
        return usersList;
    }

    public UserModel getUserById(Integer id){
        UserModel singleUser = userRepo.findById(id).get();
        return singleUser;
    }

    public void deleteUserById(Integer id){
        userRepo.deleteById(id);
    }


}
