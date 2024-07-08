package com.example.lesson8.service;


import com.example.lesson8.entity.User;

import java.util.List;

public interface UserService {
    User create(User user);
    User get(Long id);
    User update(Long id, User user);

    User getUserByEmail(String email);
    List<User> getUsersByNameContaining(String name);
    List<User> getUsersByGender(String gender);
    int updateGenderWhereNull(String gender);
}
