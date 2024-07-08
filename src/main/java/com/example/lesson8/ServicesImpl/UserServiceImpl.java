package com.example.lesson8.ServicesImpl;

import com.example.lesson8.Repositories.UserRepository;
import com.example.lesson8.ServicesInterfaces.UserService;
import com.example.lesson8.Entities.User;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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
    //@Cacheable("users")
    public User get(Long id) {
        log.info("getting user by id: {}", id);
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Пользователь не найден по id " + id));
    }

    @Override
    //@CachePut(value="users", key = "#id")
    public User update(Long id, User user) {
        User existingUser = repository.findById(id)
                        .orElseThrow(()-> new EntityNotFoundException("Пользователь не найден по id " + id));
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        log.info("Обновлен пользователь с id: {}", id);
        return repository.save(existingUser);
    }

    public User getUserByEmail(String email) {
        log.info("Получение пользователей по email: {}", email);
        return repository.findByEmail(email);
    }

    public List<User> getUsersByNameContaining(String name) {
        log.info("Получение пользователей по имени: {}", name);
        return repository.findByNameContaining(name);
    }

    public List<User> getUsersByGender(String gender) {
        log.info("Получение пользователей по полу: {}", gender);
        return repository.findByGender(gender);
    }

    public int updateGenderWhereNull(String gender) {
        log.info("Обновлены поля на {}, где было NULL", gender);
        return repository.updateGenderWhereNull(gender);
    }

}
