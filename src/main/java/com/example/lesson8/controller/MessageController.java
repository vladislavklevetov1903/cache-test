package com.example.lesson8.controller;


import com.example.lesson8.entity.Message;
import com.example.lesson8.service.MessageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@Tag(name = "Messages", description = "Working with the BD 'messages'")
@RestController
@RequestMapping(path="/messages", produces = MediaType.APPLICATION_JSON_VALUE)
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }


    @Operation(summary = "Create Message")
    @PostMapping("/create")
    public Message createMessage(@RequestParam String text, @RequestParam Long senderId) {
        return messageService.createMessage(text, senderId);
    }


    @Operation(summary = "Get all Messages")
    @GetMapping("/getMessages")
    public Iterable<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    @Operation(summary = "Search messages by Id")
    @GetMapping("/getMessageById")
    public Message getMessageById(@RequestParam Long messageId) {
        return messageService.getMessageById(messageId);
    }

    @Operation(summary = "Delete Message by Id")
    @DeleteMapping("/delete")
    public void deleteMessage(@RequestParam Long messageId) {
        messageService.deleteMessage(messageId);
    }

}
