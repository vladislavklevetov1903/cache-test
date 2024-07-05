package com.example.lesson8;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
public class MessageConroller {

    private final MessageService messageService;

    @Autowired
    public MessageConroller(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/create")
    public Message createMessage(@RequestParam String text, @RequestParam Long senderId) {
        return messageService.createMessage(text, senderId);
    }

    @GetMapping("/getMessages")
    public Iterable<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    @GetMapping("/getMessageById")
    public Message getMessageById(@RequestParam Long messageId) {
        return messageService.getMessageById(messageId);
    }

    @DeleteMapping("/delete")
    public void deleteMessage(@RequestParam Long messageId) {
        messageService.deleteMessage(messageId);
    }
}
