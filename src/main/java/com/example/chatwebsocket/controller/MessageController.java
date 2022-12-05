package com.example.chatwebsocket.controller;

import com.example.chatwebsocket.entity.Message;
import com.example.chatwebsocket.entity.User;
import com.example.chatwebsocket.service.UserServiceImpl;
import com.example.chatwebsocket.storage.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class MessageController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private UserServiceImpl userService;

    @MessageMapping("/chat/{to}")
    public void sendMessage(@DestinationVariable String to, Message message){
        System.out.println("handling send message: "+message+" to: "+to);
        boolean isExists= UserStorage.getInstance().getUsers().contains(to);
        System.out.println(isExists+"=isExists");
        if (isExists){
            simpMessagingTemplate.convertAndSend("/topic/messages/"+to, message);
        }
    }

    @MessageMapping("/chat1/{to}")
    public void sendMessage1(@DestinationVariable String to, Message message){
        boolean isExists=false;
        System.out.println("handling send message: "+message+" to: "+to);
        List<User> users=userService.getAllUser();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().contains(to)){
                isExists=true;
            }
        }
        System.out.println(isExists+"=isExists");
        if (isExists){
            simpMessagingTemplate.convertAndSend("/topic/messages/"+to, message);
        }
    }
}
