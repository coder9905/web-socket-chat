package com.example.chatwebsocket.service;

import com.example.chatwebsocket.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl {

    public List<User> getAllUser(){
        List<User> userList=new ArrayList<User>();
        User user=new User("Ali1","12");
        User user1=new User("Ali2","12");
        User user2=new User("Ali3","12");
        User user3=new User("Ali4","12");
        User user4=new User("Ali5","12");
        userList.add(user);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        return userList;
    }

}
