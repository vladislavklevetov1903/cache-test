package com.example.lesson8.ServicesInterfaces;

import com.example.lesson8.Entities.Message;

public interface MessageService {


    Message createMessage(String text, Long senderId);
    Iterable<Message> getAllMessages();
    Message getMessageById(Long id);
    void deleteMessage(Long id);
}
