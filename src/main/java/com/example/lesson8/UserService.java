package com.example.lesson8;


public interface UserService {
    User create(User user);
    User get(Long id);
    User update(Long id, User user);
}
