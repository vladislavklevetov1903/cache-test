package com.example.lesson8;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User create(User user) {
        return repository.save(user);
    }

    @Override
    @Cacheable("users")
    public User get(Long id) {
        log.info("getting user by id: {}", id);
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Пользователь не найден по id " + id));
    }

    @Override
    @CachePut(value="users", key = "#id")
    public User update(Long id, User user) {
        User existingUser = repository.findById(id)
                        .orElseThrow(()-> new EntityNotFoundException("Пользователь не найден по id " + id));
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        log.info("Обновлен пользователь с id: {}", id);
        return repository.save(existingUser);
    }


}
