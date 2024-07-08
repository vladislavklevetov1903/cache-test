package com.example.lesson8.service.ServicesImpl;


import com.example.lesson8.entity.Message;
import com.example.lesson8.repository.MessageRepository;
import com.example.lesson8.repository.UserRepository;
import com.example.lesson8.service.MessageService;
import com.example.lesson8.entity.User;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final UserRepository repository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository, UserRepository repository) {
        this.messageRepository = messageRepository;
        this.repository = repository;
    }

    public Message createMessage(String text, Long senderId){
        Optional<User> sender = repository.findById(senderId);
        if(sender.isPresent()) {
            Message message = new Message(text, sender.get());
            return messageRepository.save(message);
        }
        throw new EntityNotFoundException("К сожалению, пользователя с таким ID нет.");
    }

    public Iterable<Message> getAllMessages(){
        log.info("Получение всех сообщений");
        return messageRepository.findAll();
    }

    public Message getMessageById(Long id){
        return messageRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Не найдено сообщения с id: " + id));
    }

    @Override
    public void deleteMessage(Long id) {
        messageRepository.deleteById(id);
    }

}
