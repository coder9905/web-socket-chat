package com.example.chatwebsocket.controller;

import com.example.chatwebsocket.service.UserServiceImpl;
import com.example.chatwebsocket.storage.UserStorage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin
public class UserController {

    private final UserServiceImpl userList;

    public UserController(UserServiceImpl userList) {
        this.userList = userList;
    }

    @GetMapping("/registration/{userName}")
    public ResponseEntity<?> register(@PathVariable("userName") String username){
        try {
            UserStorage.getInstance().setUsers(username);
            System.out.println("handling register user ruquest: "+username);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/fetchAllUsers")
    public Set<String> fetchAll(){
        System.out.println(UserStorage.getInstance().getUsers());
        return UserStorage.getInstance().getUsers();
    }

    @GetMapping("/fetchAllUsersList")
    public ResponseEntity<?> fetchAllUsers(){
        System.out.println(userList.getAllUser());
        return ResponseEntity.ok(userList.getAllUser());
    }



}
