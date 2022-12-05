//package com.example.chatwebsocket.controller;
//
//import com.example.chatwebsocket.entity.Message;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//public class WsController {
//
//    @Autowired
//    SimpMessagingTemplate template;
//
//    @GetMapping("/")
//    public String zor(){
//        return "Keldi";
//    }
//
//    @PostMapping("/send")
//    public ResponseEntity send(@RequestBody Message textMessage) {
//        template.convertAndSend("/topic/messages", textMessage);
//        return ResponseEntity.ok().build();
//    }
//
//    @MessageMapping("/sendMessage")
//    @SendTo("/topic/messages")
//    public Message sendMessage(Message message) {
//        return message;
//    }
//}
